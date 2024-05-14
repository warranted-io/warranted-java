package com.warranted;

import java.util.List;

public class LawEnforcementRequestsResponse {
    private List<LawEnforcementRequest> lawEnforcementRequests;

    public List<LawEnforcementRequest> getLawEnforcementRequests() {
        return lawEnforcementRequests;
    }

    public void setLawEnforcementRequests(List<LawEnforcementRequest> lawEnforcementRequests) {
        this.lawEnforcementRequests = lawEnforcementRequests;
    }
}