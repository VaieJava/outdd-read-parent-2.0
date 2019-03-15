package com.outdd.oauthserver.feign;

import com.outdd.api.service.MemberApiService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/*
 * TODO: [NAME]
 * @author VAIE
 * @date: 2019/3/14-22:47
 * @version v1.0
 */
@Component
@FeignClient("member-server")
public interface MemberApiServiceFeign extends MemberApiService {
}
