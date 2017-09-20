package com.malaria.ssm.module.preDeal.service.Impl;

import com.malaria.ssm.module.preDeal.service.PreDealService;
import org.springframework.stereotype.Service;

/**
 * Created by 郑晓辉 on 2016/10/23.
 */
@Service
public class PreDealServiceImpl implements PreDealService {
//    @Resource
//    private PreDealMapper preDealMapper;
//    @Resource
//    private AddressGeocodeMapper addressGeocodeMapper;
//
//    public List<String> getAddressList() throws Exception {
//        return preDealMapper.selectAddressArray();
//    }
//
//    public void saveAddsAndCodes(List<AddressGeocode> addsAndCodeList) throws Exception {
//        for (AddressGeocode a : addsAndCodeList) {
//            if (null == addressGeocodeMapper.selectByPrimaryKey(a.getAddress())) {
//                if (1 == addressGeocodeMapper.insert(a)) {
//                    continue;
//                }
//            }
//            if (1 == addressGeocodeMapper.updateByPrimaryKey(a)) {
//                System.out.println("更新了地址信息：" + a.getAddress());
//            }
//        }
//    }
}
