/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.controller;

import cn.zhuatech.recruitai.common.ApiResponse;
import cn.zhuatech.recruitai.service.CandidateDecisionAuditService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/recruitai")
public class CandidateDecisionAuditController {
    private final CandidateDecisionAuditService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CandidateDecisionAuditController(CandidateDecisionAuditService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/candidate-decision-audit")
    public ApiResponse<CandidateDecisionAuditService.AuditResult> audit(
            @Valid @RequestBody CandidateDecisionAuditService.AuditRequest request) {
        return ApiResponse.ok("候选人决定审计完成", service.audit(request));
    }
}
