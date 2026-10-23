/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.workbench;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cn.zhuatech.recruitai.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@SpringBootTest
@AutoConfigureMockMvc
class AiWorkbenchSecurityIntegrationTest {
  @Autowired MockMvc mvc;
  @Autowired JwtService jwt;

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void securityFilterRejectsAnonymous() throws Exception {
    mvc.perform(
            post("/api/workbench/interview-availability")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"durationMinutes\":60,\"participants\":[{\"id\":\"P1\",\"available\":[{\"start\":\"2026-10-23T09:00\",\"end\":\"2026-10-23T12:00\"}],\"busy\":[{\"start\":\"2026-10-23T10:00\",\"end\":\"2026-10-23T11:00\"}]},{\"id\":\"P2\",\"available\":[{\"start\":\"2026-10-23T09:30\",\"end\":\"2026-10-23T12:00\"}],\"busy\":[]}]}"))
        .andExpect(status().isUnauthorized());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void securityFilterRejectsInvalidBearer() throws Exception {
    mvc.perform(
            post("/api/workbench/interview-availability")
                .header("Authorization", "Bearer invalid-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"durationMinutes\":60,\"participants\":[{\"id\":\"P1\",\"available\":[{\"start\":\"2026-10-23T09:00\",\"end\":\"2026-10-23T12:00\"}],\"busy\":[{\"start\":\"2026-10-23T10:00\",\"end\":\"2026-10-23T11:00\"}]},{\"id\":\"P2\",\"available\":[{\"start\":\"2026-10-23T09:30\",\"end\":\"2026-10-23T12:00\"}],\"busy\":[]}]}"))
        .andExpect(status().isUnauthorized());
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void authenticatedCallerCanCompute() throws Exception {
    mvc.perform(
            post("/api/workbench/interview-availability")
                .header("Authorization", "Bearer " + jwt.generate("operator"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"durationMinutes\":60,\"participants\":[{\"id\":\"P1\",\"available\":[{\"start\":\"2026-10-23T09:00\",\"end\":\"2026-10-23T12:00\"}],\"busy\":[{\"start\":\"2026-10-23T10:00\",\"end\":\"2026-10-23T11:00\"}]},{\"id\":\"P2\",\"available\":[{\"start\":\"2026-10-23T09:30\",\"end\":\"2026-10-23T12:00\"}],\"busy\":[]}]}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true));
  }

  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  @Test
  void authenticatedCallerGetsValidationError() throws Exception {
    mvc.perform(
            post("/api/workbench/interview-availability")
                .header("Authorization", "Bearer " + jwt.generate("operator"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.success").value(false));
  }
}
