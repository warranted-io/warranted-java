package io.warranted;

import java.util.List;

/**
 * <p>LawEnforcementRequestsResponse class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class LawEnforcementRequestsResponse {
    private List<LawEnforcementRequest> lawEnforcementRequests;

    /**
     * <p>Getter for the field <code>lawEnforcementRequests</code>.</p>
     *
     * @return a {@link java.util.List} object
     */
    public List<LawEnforcementRequest> getLawEnforcementRequests() {
        return lawEnforcementRequests;
    }

    /**
     * <p>Setter for the field <code>lawEnforcementRequests</code>.</p>
     *
     * @param lawEnforcementRequests a {@link java.util.List} object
     */
    public void setLawEnforcementRequests(List<LawEnforcementRequest> lawEnforcementRequests) {
        this.lawEnforcementRequests = lawEnforcementRequests;
    }
}
