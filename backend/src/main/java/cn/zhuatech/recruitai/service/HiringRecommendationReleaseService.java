/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HiringRecommendationReleaseService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.jobCriteriaApproved()) blockers.add("岗位评价标准未审批");
        if (!request.protectedAttributesExcluded()) blockers.add("推荐特征包含受保护属性或其明显代理变量");
        if (!request.explainabilityComplete()) blockers.add("候选人推荐理由不可解释");
        if (!request.disparateImpactAssessmentPassed()) blockers.add("差异影响评估未通过");
        if (!request.candidateNoticeAndConsentComplete()) blockers.add("候选人 AI 使用告知或同意未完成");
        if (!request.humanDecisionMakerAssigned()) blockers.add("未指定最终人工决策人");
        if (!request.finalApprovalComplete()) blockers.add("招聘推荐发布审批未完成");
        if (!blockers.isEmpty()) {
            actions.add("阻断推荐发布并由招聘、法务和数据治理共同整改");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.appealChannelReady() || !request.modelVersionRecorded() || !request.retentionPolicyApplied()) {
            if (!request.appealChannelReady()) actions.add("建立候选人询问与申诉渠道");
            if (!request.modelVersionRecorded()) actions.add("记录模型、提示词和规则版本");
            if (!request.retentionPolicyApplied()) actions.add("应用候选人数据保留与删除策略");
            return new Assessment(Decision.PANEL_REVIEW, blockers, actions);
        }
        actions.add("向招聘评审小组发布建议，最终决定仍由授权人员作出");
        return new Assessment(Decision.RELEASE, blockers, actions);
    }

    public record Request(@NotBlank String recommendationId, boolean jobCriteriaApproved,
                          boolean protectedAttributesExcluded, boolean explainabilityComplete,
                          boolean disparateImpactAssessmentPassed, boolean candidateNoticeAndConsentComplete,
                          boolean humanDecisionMakerAssigned, boolean appealChannelReady,
                          boolean modelVersionRecorded, boolean retentionPolicyApplied,
                          boolean finalApprovalComplete) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { RELEASE, PANEL_REVIEW, BLOCKED }
}
