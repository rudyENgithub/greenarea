/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.vige.greenarea.sgapl.sgot.webservice.wsdata;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class RequestShippingResponseData implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6466184748534553365L;
	private ResultOperationResponse result;
    private String shippingOrderID;
    private String totalCost;//Long totalCost;
    private Long maxTimeShipment;
    private Long maxTimeValidity;

    public RequestShippingResponseData() {
        result = null;
        shippingOrderID = null;
        totalCost = null;
        maxTimeShipment = null;
        maxTimeValidity = null;
    }
    
    public RequestShippingResponseData(ResultOperationResponse result) {
        this();
        this.result = result;
    }

    public Long getMaxTimeShipment() {
        return maxTimeShipment;
    }

    public void setMaxTimeShipment(Long maxTimeShipment) {
        this.maxTimeShipment = maxTimeShipment;
    }

    public Long getMaxTimeValidity() {
        return maxTimeValidity;
    }

    public void setMaxTimeValidity(Long maxTimeValidity) {
        this.maxTimeValidity = maxTimeValidity;
    }
    
    public ResultOperationResponse getResult() {
        return result;
    }

    public void setResult(ResultOperationResponse result) {
        this.result = result;
    }
    
    public String getShippingOrderID() {
        return shippingOrderID;
    }

    public void setShippingOrderID(String shippingOrderID) {
        this.shippingOrderID = shippingOrderID;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
    
}
