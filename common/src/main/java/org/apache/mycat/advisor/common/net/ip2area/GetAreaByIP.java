/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.apache.mycat.advisor.common.net.ip2area;

import com.alibaba.fastjson.JSONObject;
import org.apache.mycat.advisor.common.net.http.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * functional describe:从淘宝地址库获取IP对应的真实物理地址
 *
 * @author DR.YangLong
 * @version 1.0
 */
public class GetAreaByIP {
    /**
     * taobaoIP分享库地址,使用get方法
     */
    private static final String requestURL = "http://ip.taobao.com/service/getIpInfo.php?ip=USERIP";
    
    private static Logger logger = LoggerFactory.getLogger(GetAreaByIP.class);

    /**
     * 获取真实IP，请求头中添加X-Real-IP
     *
     * @param request request
     * @return ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip == "") {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static AreaDomain getUserAreaByIP(final String ip) {
        AreaDomain areaDomain  = null;
		try {
			JSONObject jsonObject= HttpService.doHttpRequestGetJson(requestURL.replaceAll("USERIP", ip), "GET", null);
			if(jsonObject.getInteger("code")==0){
			    jsonObject=jsonObject.getJSONObject("data");
			    areaDomain= JSONObject.toJavaObject(jsonObject, AreaDomain.class);
			}
		} catch (Exception e) {
			logger.warn("通过淘宝API根据IP获取地址出错");
		}
        return areaDomain;
    }
}
