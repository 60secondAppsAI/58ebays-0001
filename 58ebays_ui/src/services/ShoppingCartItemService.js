import http from "../http-common"; 

class ShoppingCartItemService {
  getAllShoppingCartItems(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/shoppingCartItem/shoppingCartItems`, searchDTO);
  }

  get(shoppingCartItemId) {
    return this.getRequest(`/shoppingCartItem/${shoppingCartItemId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/shoppingCartItem?field=${matchData}`, null);
  }

  addShoppingCartItem(data) {
    return http.post("/shoppingCartItem/addShoppingCartItem", data);
  }

  update(data) {
  	return http.post("/shoppingCartItem/updateShoppingCartItem", data);
  }
  
  uploadImage(data,shoppingCartItemId) {
  	return http.postForm("/shoppingCartItem/uploadImage/"+shoppingCartItemId, data);
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

export default new ShoppingCartItemService();
