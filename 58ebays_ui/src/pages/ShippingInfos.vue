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
            <shippingInfo-table
            v-if="shippingInfos && shippingInfos.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:shippingInfos="shippingInfos"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-shipping-infos="getAllShippingInfos"
             >

            </shippingInfo-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import ShippingInfoTable from "@/components/ShippingInfoTable";
import ShippingInfoService from "../services/ShippingInfoService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ShippingInfoTable,
  },
  data() {
    return {
      shippingInfos: [],
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
    async getAllShippingInfos(sortBy='shippingInfoId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ShippingInfoService.getAllShippingInfos(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.shippingInfos.length) {
					this.shippingInfos = response.data.shippingInfos;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching shippingInfos:", error);
        }
        
      } catch (error) {
        console.error("Error fetching shippingInfo details:", error);
      }
    },
  },
  mounted() {
    this.getAllShippingInfos();
  },
  created() {
    this.$root.$on('searchQueryForShippingInfosChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllShippingInfos();
    })
  }
};
</script>
<style></style>
