package com.malaria.ssm.module.upload.service.impl;

import com.malaria.ssm.module.upload.pojo.*;
import com.malaria.ssm.module.upload.service.UploadToCardInformService;
import com.malaria.ssm.module.whole.mapper.*;
import com.malaria.ssm.module.whole.pojo.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 郑晓辉 on 2017/1/21.
 */
@Service
public class UploadToCardInformServiceImpl implements UploadToCardInformService {

    @Resource
    private CardInformationMapper cardInformationMapper;
    @Resource
    private CaseCategory1Mapper caseCategory1Mapper;
    @Resource
    private CaseCategory2Mapper caseCategory2Mapper;
    @Resource
    private DiseaseMapper diseaseMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private PatientBelongsMapper patientBelongsMapper;
    @Resource
    private CareerMapper careerMapper;
    @Resource
    private AddressGeocodeMapper addressGeocodeMapper;
    @Resource
    private MedicalUnitMapper medicalUnitMapper;
    @Resource
    private DoctorMapper doctorMapper;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UploadToCardInformServiceImpl.class);

//    private List<Integer> errorRowsCode;
//    private List<Integer> savedRowsCode;

    public Data2DBInfo saveDataToDB(String filePath) throws Exception {
//        try {
//            this.errorRowsCode.clear();
//            this.savedRowsCode.clear();
//        } catch (Exception e) {
//            logger.error("this.errorRowsCode.clear();\n" +
//                    "            this.savedRowsCode.clear(); Exception : " + e.getMessage());
//        }
        List<Integer> errorRowsCode = new ArrayList<>();
        List<Integer> savedRowsCode = new ArrayList<>();
        //文件流数据
        InputStream fileStream = new FileInputStream(filePath);
        //获取excel单元格数值
        GetExcelValue getExcelValue = new GetExcelValue();
        //excel低版本
        if (filePath.endsWith(".xls")) {
            //创建工作簿
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileStream);
            //遍历sheet表
            for (int sheetNum = 0; sheetNum < hssfWorkbook.getNumberOfSheets(); sheetNum++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNum);
                if (null == hssfSheet) {
                    continue;
                }
                //获取第一行字段名
                HSSFRow firstRow = hssfSheet.getRow(0);
                List<String> fieldNames = new ArrayList<>();
                for (int cellNum = 0; cellNum < firstRow.getLastCellNum(); cellNum++) {
                    fieldNames.add(cellNum, getExcelValue.getValue(firstRow.getCell(cellNum)));
                }
                //遍历行，此处从第二行开始，第一行为字段名
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    Map<String, String> cellValues = new HashMap<>();
                    for (int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++) {
                        cellValues.put(fieldNames.get(cellNum), getExcelValue.getValue(hssfRow.getCell(cellNum)));
                    }
                    //根据字段判断上传的文件，同时上传数据到数据库
                    if (switchTable(fieldNames, cellValues, rowNum)) {
                        savedRowsCode.add(rowNum);
                    } else {
                        errorRowsCode.add(rowNum);
                    }
                }
            }
        }
        //excel高版本
        if (filePath.endsWith(".xlsx")) {
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileStream);
            //遍历sheet表
            for (int sheetNum = 0; sheetNum < xssfWorkbook.getNumberOfSheets(); sheetNum++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetNum);
                if (null == xssfSheet) {
                    continue;
                }
                //获取第一行字段名
                XSSFRow firstRow = xssfSheet.getRow(0);
                List<String> fieldNames = new ArrayList<>();
                for (int cellNum = 0; cellNum < firstRow.getLastCellNum(); cellNum++) {
                    fieldNames.add(cellNum, getExcelValue.getValue(firstRow.getCell(cellNum)));
                }
                //遍历行，此处从第二行开始，第一行为字段名
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    Map<String, String> cellValues = new HashMap<>();
                    for (int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++) {
                        cellValues.put(fieldNames.get(cellNum), getExcelValue.getValue(xssfRow.getCell(cellNum)));
                    }
                    //根据字段判断上传的文件，同时上传数据到数据库
                    if (switchTable(fieldNames, cellValues, rowNum)) {
                        savedRowsCode.add(rowNum);
                    } else {
                        errorRowsCode.add(rowNum);
                    }
                }
            }
        }
        Data2DBInfo data2DBInfo = new Data2DBInfo();
        data2DBInfo.setErrorRowsCode(errorRowsCode);
        data2DBInfo.setSavedRowsTotal(savedRowsCode.size());
        return data2DBInfo;
    }

    /**
     * 上传数据到数据库，记录行数据正确保存、错误的行数到全局变量
     *
     * @param fieldNames
     * @param cellValues
     * @param rowNum
     * @throws Exception
     */
    private Boolean switchTable(List<String> fieldNames, Map<String, String> cellValues, int rowNum) throws Exception {
        Boolean flag = null;
        switch (fieldNames.size()) {
            case 45:
                RowDataSorted<CardInform, ErrorCardInform> rowDataSorted = cardInformationCellData(cellValues);
                if (rowDataSorted.getHasError()) {//行数据有错
//                    this.errorRowsCode.add(rowNum);
                    flag = false;
                } else {//行数据没有错误
                    Upload2DBInfo upload2DBInfo = saveDataToDB(rowDataSorted.getCorrectData());
                    if (upload2DBInfo.isSuccessOp()) {
                        //记录成功插入第几行的数据
//                        this.savedRowsCode.add(rowNum);
                        flag = true;
                    }
                }
                break;
            case 1:
                break;
            default:
        }
        return flag;
    }

    /**
     * 对行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private RowDataSorted<CardInform, ErrorCardInform> cardInformationCellData(Map<String, String> cellValues) throws Exception {
        RowDataSorted<CardInform, ErrorCardInform> rowDataSorted = new RowDataSorted<>();
        Date nullDate = null;
        DateFormat df = DateFormat.getDateInstance();
        nullDate = df.parse("0000-00-00");
        try {
            CardInform cardInform = new CardInform();
            cardInform.setYear(Integer.parseInt(cellValues.get("数据年份")));
            cardInform.setCardID(Integer.parseInt(cellValues.get("卡片ID")));
            cardInform.setCardNum(cellValues.get("卡片编号"));
            if (cellValues.get("卡片状态").trim().equals("原始卡")) {
                cardInform.setCardStatus(CONSTANT.getOriginCardstatus());
            } else if (cellValues.get("卡片状态").trim().equals("订正卡")) {
                cardInform.setCardStatus(CONSTANT.getRevisedCardstatus());
            } else {
                cardInform.setCardStatus(CONSTANT.getUknownCardstatus());
            }
            cardInform.setPatientName(cellValues.get("患者姓名"));
            if (cellValues.get("性别").trim().equals("男")) {
                cardInform.setSex(CONSTANT.getSexMale());
            } else if (cellValues.get("性别").trim().equals("女")) {
                cardInform.setSex(CONSTANT.getSexFemale());
            } else {
                cardInform.setSex(CONSTANT.getSexUnknown());
            }
            if (!cellValues.get("出生日期").equals(".")) {
                cardInform.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("出生日期")));
            } else {
                cardInform.setBirthday(nullDate);
            }

            cardInform.setAge(cellValues.get("年龄"));
            cardInform.setWorkUnit(cellValues.get("患者工作单位"));
            cardInform.setTel(cellValues.get("联系电话"));
            cardInform.setBelongsLevel(cellValues.get("病人属于"));
            cardInform.setAddressNationID(Integer.parseInt(cellValues.get("现住地址国标")));
            cardInform.setAddress(cellValues.get("现住详细地址"));
            cardInform.setCareer(cellValues.get("职业"));
            cardInform.setCaseCategory1Name(cellValues.get("病例分类"));
            cardInform.setCaseCategory2Name(cellValues.get("病例分类2"));
            if (!cellValues.get("发病日期").equals(".")) {
                cardInform.setIllDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("发病日期")));
            } else {
                cardInform.setIllDate(nullDate);
            }
            if (!cellValues.get("诊断时间").equals(".")) {
                cardInform.setConfirmDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("诊断时间")));
            } else {
                cardInform.setConfirmDate(nullDate);
            }
            if (!cellValues.get("死亡日期").equals(".")) {
                cardInform.setDeathDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("死亡日期")));
            } else {
                cardInform.setDeathDate(nullDate);
            }
            cardInform.setDiseaseName(cellValues.get("疾病名称"));
            cardInform.setDiseasePreRevised(cellValues.get("订正前病种"));
            cardInform.setFillCardDoc(cellValues.get("填卡医生"));
            if (!cellValues.get("医生填卡日期").equals(".")) {
                cardInform.setFillCardDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValues.get("医生填卡日期")));
            } else {
                cardInform.setFillCardDate(nullDate);
            }
            cardInform.setReportUnitAreaCode(cellValues.get("报告单位地区编码"));
            cardInform.setReportUnit(cellValues.get("报告单位"));
            cardInform.setUnitType(cellValues.get("单位类型"));
            if (!cellValues.get("报告卡录入时间").equals(".")) {
                cardInform.setReportInputDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("报告卡录入时间")));
            } else {
                cardInform.setReportInputDate(nullDate);
            }
            cardInform.setInputUser(cellValues.get("录卡用户"));
            cardInform.setInputUserUnit(cellValues.get("录卡用户所属单位"));
            cardInform.setCountyJudgeDate(cellValues.get("县区审核时间"));
            cardInform.setLocalJudgeDate(cellValues.get("地市审核时间"));
            cardInform.setProvinceJudgeDate(cellValues.get("省市审核时间"));
            if (cellValues.get("审核状态").equals("已终审卡")) {
                cardInform.setJudgeStatus(CONSTANT.getPassJudgestatus());
            } else {
                cardInform.setJudgeStatus(CONSTANT.getOtherJudgestatus());
            }
            if (!cellValues.get("订正报告时间").equals(".")) {
                cardInform.setRevisedReportDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("订正报告时间")));
            } else {
                cardInform.setRevisedReportDate(nullDate);
            }
            if (!cellValues.get("订正终审时间").equals(".")) {
                cardInform.setRevisedFinalJudgeDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("订正终审时间")));
            } else {
                cardInform.setRevisedFinalJudgeDate(nullDate);
            }
            if (!cellValues.get("终审死亡时间").equals(".")) {
                cardInform.setDeathFinalJudgeDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("终审死亡时间")));
            } else {
                cardInform.setDeathFinalJudgeDate(nullDate);
            }
            cardInform.setRevisedUser(cellValues.get("订正用户"));
            cardInform.setRevisedUserUnit(cellValues.get("订正用户所属单位"));
            if (!cellValues.get("删除时间").equals(".")) {
                cardInform.setDelDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cellValues.get("删除时间")));
            } else {
                cardInform.setDelDate(nullDate);
            }
            cardInform.setDelUser(cellValues.get("删除用户"));
            cardInform.setDelUserUnit(cellValues.get("删除用户所属单位"));
            cardInform.setDelReason(cellValues.get("删除原因"));
            cardInform.setNotes(cellValues.get("备注"));
            rowDataSorted.setHasError(Boolean.FALSE);
            rowDataSorted.setCorrectData(cardInform);
        } catch (NumberFormatException e) {
            logger.error("NumberFormatException: " + e.getMessage());
            ErrorCardInform errorCardInform = dealError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        } catch (ParseException e) {
            logger.error("ParseException: " + e.getMessage());
            ErrorCardInform errorCardInform = dealError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            ErrorCardInform errorCardInform = dealError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorCardInform);
        }
        return rowDataSorted;

    }

    /**
     * 用于提取不符合格式的、错误的数据
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    private ErrorCardInform dealError(Map<String, String> cellValues) throws Exception {
        ErrorCardInform errorCardInform = new ErrorCardInform();
        errorCardInform.setYear(cellValues.get("数据年份"));
        errorCardInform.setCardID(cellValues.get("卡片ID"));
        errorCardInform.setCardNum(cellValues.get("卡片编号"));
        errorCardInform.setCardStatus(cellValues.get("卡片状态"));
        errorCardInform.setPatientName(cellValues.get("患者姓名"));
        errorCardInform.setSex(cellValues.get("性别"));
        errorCardInform.setBirthday(cellValues.get("出生日期"));
        errorCardInform.setAge(cellValues.get("年龄"));
        errorCardInform.setWorkUnit(cellValues.get("患者工作单位"));
        errorCardInform.setTel(cellValues.get("联系电话"));
        errorCardInform.setBelongsLevel(cellValues.get("病人属于"));
        errorCardInform.setAddressNationID(cellValues.get("现住地址国标"));
        errorCardInform.setAddress(cellValues.get("现住详细地址"));
        errorCardInform.setCareer(cellValues.get("职业"));
        errorCardInform.setCaseCategory1Name(cellValues.get("病例分类"));
        errorCardInform.setCaseCategory2Name(cellValues.get("病例分类2"));
        errorCardInform.setIllDate(cellValues.get("发病日期"));
        errorCardInform.setConfirmDate(cellValues.get("诊断时间"));
        errorCardInform.setDeathDate(cellValues.get("死亡日期"));
        errorCardInform.setDiseaseName(cellValues.get("疾病名称"));
        errorCardInform.setDiseasePreRevised(cellValues.get("订正前病种"));
        errorCardInform.setFillCardDoc(cellValues.get("填卡医生"));
        errorCardInform.setFillCardDate(cellValues.get("医生填卡日期"));
        errorCardInform.setReportUnitAreaCode(cellValues.get("报告单位地区编码"));
        errorCardInform.setReportUnit(cellValues.get("报告单位"));
        errorCardInform.setUnitType(cellValues.get("单位类型"));
        errorCardInform.setReportInputDate(cellValues.get("报告卡录入时间"));
        errorCardInform.setInputUser(cellValues.get("录卡用户"));
        errorCardInform.setInputUserUnit(cellValues.get("录卡用户所属单位"));
        errorCardInform.setCountyJudgeDate(cellValues.get("县区审核时间"));
        errorCardInform.setLocalJudgeDate(cellValues.get("地市审核时间"));
        errorCardInform.setProvinceJudgeDate(cellValues.get("省市审核时间"));
        errorCardInform.setJudgeStatus(cellValues.get("审核状态"));
        errorCardInform.setRevisedReportDate(cellValues.get("订正报告时间"));
        errorCardInform.setRevisedFinalJudgeDate(cellValues.get("订正终审时间"));
        errorCardInform.setDeathFinalJudgeDate(cellValues.get("终审死亡时间"));
        errorCardInform.setRevisedUser(cellValues.get("订正用户"));
        errorCardInform.setRevisedUserUnit(cellValues.get("订正用户所属单位"));
        errorCardInform.setDelDate(cellValues.get("删除时间"));
        errorCardInform.setDelUser(cellValues.get("删除用户"));
        errorCardInform.setDelUserUnit(cellValues.get("删除用户所属单位"));
        errorCardInform.setDelReason(cellValues.get("删除原因"));
        errorCardInform.setNotes(cellValues.get("备注"));
        return errorCardInform;
    }

    /**
     * 保存正确的行数据到数据库中
     *
     * @param rowData
     * @throws Exception
     */
    private Upload2DBInfo saveDataToDB(CardInform rowData) throws Exception {
        Upload2DBInfo upload2DBInfo = new Upload2DBInfo();
        if (null != cardInformationMapper.selectByPrimaryKey(rowData.getCardID())) {
            upload2DBInfo.setNeedUpdate(true);
            upload2DBInfo.setNeedInsert(false);
        } else {
            upload2DBInfo.setNeedUpdate(false);
            upload2DBInfo.setNeedInsert(true);
        }
        try {
            CardInformation cardInformation = new CardInformation();
            //卡片编号，主键唯一标识
            cardInformation.setCardid(rowData.getCardID());
            cardInformation.setCardnum(rowData.getCardNum());
            cardInformation.setCardstatus(rowData.getCardStatus() + "");
            cardInformation.setYear(rowData.getYear());
            cardInformation.setIlldate(rowData.getIllDate());
            cardInformation.setConfirmdate(rowData.getConfirmDate());
            cardInformation.setDeathdate(rowData.getDeathDate());
            cardInformation.setFillcarddate(rowData.getFillCardDate());
            cardInformation.setReportinputdate(rowData.getReportInputDate());
            cardInformation.setCountyjudgedate(rowData.getCountyJudgeDate());
            cardInformation.setProvincejudgedate(rowData.getProvinceJudgeDate());
            cardInformation.setLocaljudgedate(rowData.getLocalJudgeDate());
            cardInformation.setJudgestatus(rowData.getJudgeStatus() + "");
            cardInformation.setDiseaseprerevised(rowData.getDiseasePreRevised());
            cardInformation.setRevisedreportdate(rowData.getRevisedReportDate());
            cardInformation.setRevisedfinaljudgedate(rowData.getRevisedFinalJudgeDate());
            cardInformation.setDeldate(rowData.getDelDate());
            cardInformation.setDelreason(rowData.getDelReason());
            cardInformation.setNotes(rowData.getNotes());
            cardInformation.setDeathfinaljudgedate(rowData.getDeathFinalJudgeDate());
            cardInformation.setUnitetype(rowData.getUnitType());
            cardInformation.setReportuniteareacode(rowData.getReportUnitAreaCode());
            //外键部分
//        cardInformation.setCategoryid1();
            CaseCategory1Example caseCategory1Example = new CaseCategory1Example();
            caseCategory1Example.createCriteria().andCategory1nameEqualTo(rowData.getCaseCategory1Name());
            List<CaseCategory1> caseCategory1 = caseCategory1Mapper.selectByExample(caseCategory1Example);
            if (0 < caseCategory1.size()) {
                cardInformation.setCategoryid1(caseCategory1.get(0).getCategoryid1());
            } else {
                CaseCategory1 insertCase = new CaseCategory1();
                insertCase.setCategory1name(rowData.getCaseCategory1Name());
                if (1 == caseCategory1Mapper.insertSelective(insertCase)) {
                    cardInformation.setCategoryid1(insertCase.getCategoryid1());
                } else {
                    logger.error("caseCategory1Mapper.insertSelective(insertCase) 失败！");
                }
            }
//        cardInformation.setCategoryid2();
            CaseCategory2Example caseCategory2Example = new CaseCategory2Example();
            caseCategory2Example.createCriteria().andCategory2nameEqualTo(rowData.getCaseCategory2Name());
            List<CaseCategory2> caseCategory2List = caseCategory2Mapper.selectByExample(caseCategory2Example);
            if (0 < caseCategory2List.size()) {
                cardInformation.setCategoryid1(caseCategory2List.get(0).getCategoryid2());
            } else {
                CaseCategory2 insertCase = new CaseCategory2();
                insertCase.setCategory2name(rowData.getCaseCategory1Name());
                if (1 == caseCategory2Mapper.insertSelective(insertCase)) {
                    cardInformation.setCategoryid2(insertCase.getCategoryid2());
                } else {
                    logger.error("caseCategory2Mapper.insertSelective(insertCase) 失败!");
                }
            }
//        cardInformation.setPatientid();
            PatientExample patientExample = new PatientExample();
            int addressID = 0;
            AddressGeocodeExample addressGeocodeExample = new AddressGeocodeExample();
            addressGeocodeExample.createCriteria().andAddressEqualTo(rowData.getAddress());
            List<AddressGeocode> addressGeocodeList = addressGeocodeMapper.selectByExample(addressGeocodeExample);
            if (0 < addressGeocodeList.size()) {
                addressID = addressGeocodeList.get(0).getAddressid();
            } else {
                AddressGeocode addressGeocode = new AddressGeocode();
                addressGeocode.setAddress(rowData.getAddress());
                addressGeocode.setAddrnationid(rowData.getAddressNationID());
                if (1 == addressGeocodeMapper.insertSelective(addressGeocode)) {
                    addressID = addressGeocode.getAddressid();
                } else {
                    logger.error("addressGeocodeMapper.insertSelective(addressGeocode) 失败!");
                }
            }

            int careerID = 0;
            CareerExample careerExample = new CareerExample();
            careerExample.createCriteria().andCareerEqualTo(rowData.getCareer());
            List<Career> careerList = careerMapper.selectByExample(careerExample);
            if (0 < careerList.size()) {
                careerID = careerList.get(0).getCareerid();
            } else {
                Career career = new Career();
                career.setCareer(rowData.getCareer());
                if (1 == careerMapper.insertSelective(career)) {
                    careerID = career.getCareerid();
                } else {
                    logger.error("careerMapper.insertSelective(career) 失败!");
                }
            }

            int belongsID = 0;
            PatientBelongsExample patientBelongsExample = new PatientBelongsExample();
            patientBelongsExample.createCriteria().andBelongslevelEqualTo(rowData.getBelongsLevel());
            List<PatientBelongs> patientBelongsList = patientBelongsMapper.selectByExample(patientBelongsExample);
            if (0 < patientBelongsList.size()) {
                belongsID = patientBelongsList.get(0).getBelongsid();
            } else {
                PatientBelongs patientBelongs = new PatientBelongs();
                patientBelongs.setBelongslevel(rowData.getBelongsLevel());
                if (1 == patientBelongsMapper.insertSelective(patientBelongs)) {
                    belongsID = patientBelongs.getBelongsid();
                } else {
                    logger.error("patientBelongsMapper.insertSelective(patientBelongs) 失败!");
                }
            }
            patientExample.createCriteria().andPatientnameEqualTo(rowData.getPatientName())
                    .andSexEqualTo(rowData.getSex() + "")
                    .andAgeEqualTo(rowData.getAge())
                    .andBirthdayEqualTo(rowData.getBirthday())
                    .andWorkunitEqualTo(rowData.getWorkUnit())
                    .andTelEqualTo(rowData.getTel())
                    .andAddressidEqualTo(addressID)
                    .andCareeridEqualTo(careerID)
                    .andBelongsidEqualTo(belongsID);
            List<Patient> patientList = patientMapper.selectByExample(patientExample);
            if (0 < patientList.size()) {
                cardInformation.setPatientid(patientList.get(0).getPatientid());
            } else {
                Patient patient = new Patient();
                patient.setPatientname(rowData.getPatientName());
                patient.setSex(rowData.getSex() + "");
                patient.setAge(rowData.getAge());
                patient.setBirthday(rowData.getBirthday());
                patient.setWorkunit(rowData.getWorkUnit());
                patient.setTel(rowData.getTel());
                patient.setAddressid(addressID);
                patient.setCareerid(careerID);
                patient.setBelongsid(belongsID);
                if (1 == patientMapper.insertSelective(patient)) {
                    cardInformation.setPatientid(patient.getPatientid());
                } else {
                    logger.error("patientMapper.insertSelective(patient) 失败!");
                }
            }
//        cardInformation.setDiseaseid();
            DiseaseExample diseaseExample = new DiseaseExample();
            diseaseExample.createCriteria().andDiseasenameEqualTo(rowData.getDiseaseName());
            List<Disease> diseaseList = diseaseMapper.selectByExample(diseaseExample);
            if (0 < diseaseList.size()) {
                cardInformation.setDiseaseid(diseaseList.get(0).getDiseaseid());
            } else {
                Disease inserted = new Disease();
                inserted.setDiseasename(rowData.getDiseaseName());
                if (1 == diseaseMapper.insertSelective(inserted)) {
                    cardInformation.setDiseaseid(inserted.getDiseaseid());
                } else {
                    logger.error("diseaseMapper.insertSelective(inserted) 失败!");
                }
            }


//        cardInformation.setFillcarddocid();
            MedicalUnit fillCardUnit = new MedicalUnit();
            fillCardUnit.setUnitname(rowData.getReportUnit());
//            fillCardUnit.setUnitetype(rowData.getUnitType());
//            fillCardUnit.setUniteareacode(rowData.getReportUnitAreaCode());
            int fillCardUniteID = getMedicalUniteID(fillCardUnit);
            Doctor fillCardDoc = new Doctor();
            fillCardDoc.setDoctorname(rowData.getFillCardDoc());
            fillCardDoc.setMedicalunitid(fillCardUniteID);
            cardInformation.setFillcarddocid(dealDoctorID(fillCardDoc));
//        cardInformation.setInputuserid()
            MedicalUnit inputUnite = new MedicalUnit();
            inputUnite.setUnitname(rowData.getInputUserUnit());
            int inputUniteID = getMedicalUniteID(inputUnite);
            Doctor inputDoc = new Doctor();
            inputDoc.setDoctorname(rowData.getInputUser());
            inputDoc.setMedicalunitid(inputUniteID);
            cardInformation.setInputuserid(dealDoctorID(inputDoc));
//        cardInformation.setReviseduserid();
            MedicalUnit revisedUnite = new MedicalUnit();
            revisedUnite.setUnitname(rowData.getRevisedUserUnit());
            int revisedUniteID = getMedicalUniteID(revisedUnite);
            Doctor revisedDoc = new Doctor();
            revisedDoc.setDoctorname(rowData.getRevisedUser());
            revisedDoc.setMedicalunitid(revisedUniteID);
            cardInformation.setReviseduserid(dealDoctorID(revisedDoc));
//        cardInformation.setDeluserid();
            MedicalUnit delUnite = new MedicalUnit();
            delUnite.setUnitname(rowData.getDelUserUnit());
            int delUniteID = getMedicalUniteID(delUnite);
            Doctor delDoc = new Doctor();
            delDoc.setDoctorname(rowData.getDelUser());
            delDoc.setMedicalunitid(delUniteID);
            cardInformation.setDeluserid(dealDoctorID(delDoc));
            if (upload2DBInfo.isNeedUpdate()) {
                CardInformationExample cardInformationExample = new CardInformationExample();
                cardInformationExample.createCriteria().andCardidEqualTo(rowData.getCardID());
                if (1 == cardInformationMapper.updateByExampleSelective(cardInformation, cardInformationExample)) {
                    logger.trace("cardInformation更新cardID为的" + cardInformation.getCardid() + "记录  成功 ");
                } else {
                    logger.error("cardInformation更新cardID为的" + cardInformation.getCardid() + "记录  失败 ");
                }
            }
            if (upload2DBInfo.isNeedInsert()) {
                if (1 == cardInformationMapper.insert(cardInformation)) {
                    logger.trace("cardInformation插入cardID为的" + cardInformation.getCardid() + "记录  成功 ");
                } else {
                    logger.error("cardInformation插入cardID为的" + cardInformation.getCardid() + "记录  失败 ");
                }
            }
        } catch (SQLException s) {
            upload2DBInfo.setSuccessOp(false);
            logger.error("saveDataToDB(CardInform rowData) 数据库操作失败");
            return upload2DBInfo;
        } catch (Exception e) {
            upload2DBInfo.setSuccessOp(false);
            logger.error("saveDataToDB(CardInform rowData)失败 Exception信息：" + e.getMessage());
            return upload2DBInfo;
        }
        upload2DBInfo.setSuccessOp(true);
        return upload2DBInfo;
    }

    /**
     * 获取medical_unite ID值
     *
     * @param medicalUnit
     * @return
     * @throws Exception
     */
    private int getMedicalUniteID(MedicalUnit medicalUnit) throws Exception {
        MedicalUnitExample medicalUnitExample = new MedicalUnitExample();
        //uniteName为unique
        medicalUnitExample.createCriteria().andUnitnameEqualTo(medicalUnit.getUnitname());
        List<MedicalUnit> medicalUnitList = medicalUnitMapper.selectByExample(medicalUnitExample);
        try {
            if (0 < medicalUnitList.size()) {
                return medicalUnitList.get(0).getMedicalunitid();
            } else {//medical_Unit表没有该记录,此时插入记录
                MedicalUnit insertMedicalUnit = new MedicalUnit();
                insertMedicalUnit.setUnitname(medicalUnit.getUnitname());
                if (1 == medicalUnitMapper.insertSelective(insertMedicalUnit)) {
                    return insertMedicalUnit.getMedicalunitid();
                } else {
                    logger.error("medicalUnitMapper.insertSelective(insertMedicalUnit) 失败!");
                }
            }
        } catch (Exception e) {
            logger.error("medical_unite插入数据时出现Exception 错误信息：" + e.getMessage());
        }
        return 0;
    }

    /**
     * 获取医生ID
     *
     * @param doctor
     * @return
     * @throws Exception
     */
    private int dealDoctorID(Doctor doctor) throws Exception {
        DoctorExample fillCardDoctorExample = new DoctorExample();
        fillCardDoctorExample.createCriteria().andDoctornameEqualTo(doctor.getDoctorname())
                .andMedicalunitidEqualTo(doctor.getMedicalunitid());
        List<Doctor> fillCardDocList = doctorMapper.selectByExample(fillCardDoctorExample);
        if (0 < fillCardDocList.size()) {
            return fillCardDocList.get(0).getDoctorid();
        } else {
            Doctor insertDoctor = new Doctor();
            insertDoctor.setDoctorname(doctor.getDoctorname());
            try {
                insertDoctor.setMedicalunitid(doctor.getMedicalunitid());
            } catch (Exception e) {
                logger.error("doctor.setMedicalunitid(fillCardUniteID) 错误");
            }
            if (1 == doctorMapper.insert(insertDoctor)) {
                return insertDoctor.getDoctorid();
            } else {
                logger.error("doctorMapper.insert(insertDoctor) 失败!");
            }
        }
        return 0;
    }
}
