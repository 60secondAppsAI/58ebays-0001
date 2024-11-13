<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <shoppingCartItem-table
            v-if="shoppingCartItems && shoppingCartItems.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:shoppingCartItems="shoppingCartItems"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-shopping-cart-items="getAllShoppingCartItems"
             >

            </shoppingCartItem-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import ShoppingCartItemTable from "@/components/ShoppingCartItemTable";
import ShoppingCartItemService from "../services/ShoppingCartItemService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ShoppingCartItemTable,
  },
  data() {
    return {
      shoppingCartItems: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllShoppingCartItems(sortBy='shoppingCartItemId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ShoppingCartItemService.getAllShoppingCartItems(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.shoppingCartItems.length) {
					this.shoppingCartItems = response.data.shoppingCartItems;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching shoppingCartItems:", error);
        }
        
      } catch (error) {
        console.error("Error fetching shoppingCartItem details:", error);
      }
    },
  },
  mounted() {
    this.getAllShoppingCartItems();
  },
  created() {
    this.$root.$on('searchQueryForShoppingCartItemsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllShoppingCartItems();
    })
  }
};
</script>
<style></style>
