package org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm;

import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.entities.crm.CampaignExecution;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Robin on 12.01.2017.
 */
@Local
public interface CampaignTrackingLocal {

    public void addCampaignExecution(CampaignExecution campaign);

    public int existsValidCampaignExecutionAtTouchpoint(long erpProductId,
                                                        AbstractTouchpoint tp);

    public void purchaseCampaignAtTouchpoint(long erpProductId,
                                             AbstractTouchpoint tp, int units);

    public List<CampaignExecution> getAllCampaignExecutions();
}
