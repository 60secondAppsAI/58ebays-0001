import http from "../http-common"; 

class ShippingInfoService {
  getAllShippingInfos(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/shippingInfo/shippingInfos`, searchDTO);
  }

  get(shippingInfoId) {
    return this.getRequest(`/shippingInfo/${shippingInfoId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/shippingInfo?field=${matchData}`, null);
  }

  addShippingInfo(data) {
    return http.post("/shippingInfo/addShippingInfo", data);
  }

  update(data) {
  	return http.post("/shippingInfo/updateShippingInfo", data);
  }
  
  uploadImage(data,shippingInfoId) {
  	return http.postForm("/shippingInfo/uploadImage/"+shippingInfoId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new ShippingInfoService();
