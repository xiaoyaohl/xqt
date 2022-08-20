package com.dream.xqt.mgr.qqHttpApi;

import com.alibaba.fastjson.JSON;
import com.dream.xqt.mgr.qqHttpApi.req.Code2SessionReq;
import com.dream.xqt.mgr.qqHttpApi.rsp.Code2SessionRsp;
import com.dream.xqt.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author xinxiaoyao
 * @date 2022/7/25 19:23
 */
@Component
@Slf4j
public class QQUserApi {
    private static final String CODE_2_SESSIONREQ_URL = "https://api.q.qq.com/sns/jscode2session?appid=${APPID}&secret=${SECRET}&js_code=${JSCODE}&grant_type=${GRANT_TYPE}";
    /**
     * 登录凭证校验
     * GET https://api.q.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
     * @param code2SessionReq
     * @return
     */
    public Code2SessionRsp code2Session(Code2SessionReq code2SessionReq) {
        String url = CODE_2_SESSIONREQ_URL
                .replace("${APPID}", code2SessionReq.getAppId())
                .replace("${SECRET}", code2SessionReq.getSecret())
                .replace("${JSCODE}", code2SessionReq.getJsCode())
                .replace("${GRANT_TYPE}", code2SessionReq.getGrantType());

        try {
            String response = HttpClientUtil.sendGet(url);
            log.info("code2Session req code >>>>>>>> {}, rsp >>>>>>>> {}", code2SessionReq.getJsCode(), response);

            return JSON.parseObject(response, Code2SessionRsp.class);
        } catch (IOException e) {
            log.error("code2Session IOException >>>>>>>> {}", e.getMessage());
        }

        return null;
    }
}
