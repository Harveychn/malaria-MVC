package com.malaria.ssm.module.download.controller;

import com.malaria.ssm.module.download.pojo.DownloadParamVo;
import com.malaria.ssm.module.download.service.DownloadDBDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
@Controller
@RequestMapping("/DownloadDBData")
public class DownloadDBDataController {

    private DownloadParamVo downloadParamVo;

    @Resource
    private DownloadDBDataService downloadDBDataService;

    @RequestMapping(value = "downloadView")
    public String downloadView()throws Exception{
        return "common/dataDownload";
    }

    /**
     * 根据用户选择的数据类别，获取展示的字段名
     * 同时转到相应的选择页面
     *
     * @param category
     * @return
     * @throws Exception
     */
//    @RequestMapping("/fieldNameDownloadable")
//    public ModelAndView fieldNameDownloadable(@RequestParam(value = "category") String category) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        List<CategoryFieldsRe> categoryFieldsRes = downloadDBDataService.getFieldsNameDownload(category);
//        if (categoryFieldsRes != null) {
//            modelAndView.addObject("categoryFieldsRes", categoryFieldsRes);
//        } else {
//            modelAndView.addObject("categoryFieldsRes", null);
//        }
//        if ("Disease".equals(category.trim())) {
//            modelAndView.setViewName("common/downloadDisease");
//        } else if ("Weather".equals(category.trim())) {
//            modelAndView.setViewName("common/downloadWeather");
//        } else if ("Station".equals(category.trim())) {
//            modelAndView.setViewName("common/downloadStation");
//        } else {
//            modelAndView.setViewName("error/404");
//        }
//        return modelAndView;
//    }
//
//    /**
//     * 疟疾数据下载
//     *
//     * @param requests
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/diseaseParams")
//    public
//    @ResponseBody
//    int diseaseParams(HttpServletRequest requests) throws Exception {
//        DownloadParamVo downloadParamVo = new DownloadParamVo();
//        String[] selectedFields = requests.getParameterValues("selectedFields");
//        String province = requests.getParameter("province");
//        String city = requests.getParameter("city");
//        String county = requests.getParameter("county");
//        String village = requests.getParameter("village");
//        int minAge = 0;
//        try {
//            minAge = Integer.parseInt(requests.getParameter("minAge"));
//        } catch (NumberFormatException e) {
//            minAge = 0;
//            System.out.println("minAge转换出现问题 信息：" + e.getMessage());
//        }
//        int maxAge = 0;
//        try {
//            maxAge = Integer.parseInt(requests.getParameter("maxAge"));
//        } catch (NumberFormatException e) {
//            maxAge = 0;
//            System.out.println("maxAge转换出现问题 信息：" + e.getMessage());
//        }
//        int beginYear = 0;
//        try {
//            beginYear = Integer.parseInt(requests.getParameter("beginYear"));
//        } catch (NumberFormatException e) {
//            System.out.println("beginYear转换错误 信息：" + e.getMessage());
//            beginYear = 0;
//        }
//        int endYear = 0;
//        try {
//            endYear = Integer.parseInt(requests.getParameter("endYear"));
//        } catch (NumberFormatException e) {
//            System.out.println("endYear转换错误 信息：" + e.getMessage());
//            endYear = 0;
//        }
//        int sex = 0;
//        try {
//            sex = Integer.parseInt(requests.getParameter("sex").trim());
//        } catch (NumberFormatException e) {
//            System.out.println("sex信息转换错误 信息：" + e.getMessage());
//            sex = 0;
//        }
//        if (!("未选".equals(province) || null == province || "".equals(province))) {
//            downloadParamVo.setAddrLevel1(province);
//        }
//        if (!("未选".equals(city) || null == city || "".equals(city))) {
//            downloadParamVo.setAddrLevel2(city);
//        }
//        if (!("未选".equals(county) || null == county || "".equals(county))) {
//            downloadParamVo.setAddrLevel3(county);
//        }
//        if (!("未选".equals(village) || null == village || "".equals(village))) {
//            downloadParamVo.setAddrLevel4(village);
//        }
//        if (null != selectedFields) {
//            List<String> displayFields = Arrays.asList(selectedFields);
//            if (displayFields.size() > 0) {
//                downloadParamVo.setSelectedName(displayFields);
//            }
//            downloadParamVo.setBeginYear(beginYear);
//            downloadParamVo.setEndYear(endYear);
//            downloadParamVo.setSex(sex);
//            downloadParamVo.setMinAge(minAge);
//            downloadParamVo.setMaxAge(maxAge);
//            downloadParamVo.setCategory("Disease");
//        }
//        this.downloadParamVo = downloadParamVo;
//        System.out.println("执行了'/diseaseParam.do'");
//        return 1;
//    }
//
//    /**
//     * 气候数据下载
//     *
//     * @param requests
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/weatherParams")
//    public
//    @ResponseBody
//    int weatherParams(HttpServletRequest requests) throws Exception {
//        DownloadParamVo downloadParamVo = new DownloadParamVo();
//        String[] selectedFields = requests.getParameterValues("selectedFields");
////        String province = requests.getParameter("province");
////        String city = requests.getParameter("city");
////        String county = requests.getParameter("county");
////        String village = requests.getParameter("village");
//        int beginYear = 0;
//        try {
//            beginYear = Integer.parseInt(requests.getParameter("beginYear"));
//        } catch (NumberFormatException e) {
//            System.out.println("beginYear转换错误 信息：" + e.getMessage());
//            beginYear = 0;
//        }
//        int endYear = 0;
//        try {
//            endYear = Integer.parseInt(requests.getParameter("endYear"));
//        } catch (NumberFormatException e) {
//            System.out.println("endYear转换错误 信息：" + e.getMessage());
//            endYear = 0;
//        }
////        if (!("未选".equals(province) || null == province || "".equals(province))) {
////            downloadParamVo.setAddrLevel1(province);
////        }
////        if (!("未选".equals(city) || null == city || "".equals(city))) {
////            downloadParamVo.setAddrLevel2(city);
////        }
////        if (!("未选".equals(county) || null == county || "".equals(county))) {
////            downloadParamVo.setAddrLevel3(county);
////        }
////        if (!("未选".equals(village) || null == village || "".equals(village))) {
////            downloadParamVo.setAddrLevel4(village);
////        }
//        if (null != selectedFields) {
//            List<String> displayFields = Arrays.asList(selectedFields);
//            if (displayFields.size() > 0) {
//                downloadParamVo.setSelectedName(displayFields);
//            }
//            downloadParamVo.setBeginYear(beginYear);
//            downloadParamVo.setEndYear(endYear);
//            downloadParamVo.setCategory("Weather");
//        }
//        this.downloadParamVo = downloadParamVo;
//        System.out.println("执行了weatherParam.do");
//        return 1;
//    }
//
//    @RequestMapping("/stationParams")
//    public
//    @ResponseBody
//    int stationParams(HttpServletRequest requests) throws Exception{
//        DownloadParamVo downloadParamVo = new DownloadParamVo();
//        String[] selectedFields = requests.getParameterValues("selectedFields");
//        if (null != selectedFields) {
//            List<String> displayFields = Arrays.asList(selectedFields);
//            if (displayFields.size() > 0) {
//                downloadParamVo.setSelectedName(displayFields);
//            }
//            downloadParamVo.setCategory("Station");
//        }
//        this.downloadParamVo = downloadParamVo;
//        System.out.println("执行了stationParam.do");
//        return 1;
//    }
//    /**
//     * 生成Excel文件
//     *
//     * @param response
//     * @throws Exception
//     */
//    @RequestMapping("/downloadExcel")
//    public void downLoadExcel(HttpServletResponse response) throws Exception {
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("multipart/form-data");
//        response.setHeader("Content-Disposition", "attachment;fileName=download");
//        DownloadParamVo downloadParamVo = this.downloadParamVo;
//        HSSFWorkbook workbook = downloadDBDataService.downloadData(downloadParamVo);
//        Date currentDate = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
//        String fileName = sdf.format(currentDate);
//        if ("Disease".equals(downloadParamVo.getCategory().trim())) {
//            fileName += "疟疾";
//        } else if ("Weather".equals(downloadParamVo.getCategory().trim())) {
//            fileName += "气候";
//        } else if ("Station".equals(downloadParamVo.getCategory().trim())) {
//            fileName += "观测站";
//        }
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            workbook.write(os);
//        } catch (IOException io) {
//            System.out.println("workbook.write(os)出现IOException 信息：" + io.getMessage());
//        }
//        byte[] content = os.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
//        response.reset();
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
//        ServletOutputStream out = response.getOutputStream();
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            bis = new BufferedInputStream(is);
//            bos = new BufferedOutputStream(out);
//            byte[] buff = new byte[2048];
//            int bytesRead;
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//        } catch (final IOException e) {
//            throw e;
//        } finally {
//            if (bis != null)
//                bis.close();
//            if (bos != null)
//                bos.close();
//        }
//        return;
//    }
}



