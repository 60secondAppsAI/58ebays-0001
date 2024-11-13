import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Users from  '@/pages/Users.vue';
import UserDetail from  '@/pages/UserDetail.vue';
import Items from  '@/pages/Items.vue';
import ItemDetail from  '@/pages/ItemDetail.vue';
import Bids from  '@/pages/Bids.vue';
import BidDetail from  '@/pages/BidDetail.vue';
import Categorys from  '@/pages/Categorys.vue';
import CategoryDetail from  '@/pages/CategoryDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Feedbacks from  '@/pages/Feedbacks.vue';
import FeedbackDetail from  '@/pages/FeedbackDetail.vue';
import Addresss from  '@/pages/Addresss.vue';
import AddressDetail from  '@/pages/AddressDetail.vue';
import Orders from  '@/pages/Orders.vue';
import OrderDetail from  '@/pages/OrderDetail.vue';
import ShoppingCarts from  '@/pages/ShoppingCarts.vue';
import ShoppingCartDetail from  '@/pages/ShoppingCartDetail.vue';
import ShoppingCartItems from  '@/pages/ShoppingCartItems.vue';
import ShoppingCartItemDetail from  '@/pages/ShoppingCartItemDetail.vue';
import Watchlists from  '@/pages/Watchlists.vue';
import WatchlistDetail from  '@/pages/WatchlistDetail.vue';
import Messages from  '@/pages/Messages.vue';
import MessageDetail from  '@/pages/MessageDetail.vue';
import Notifications from  '@/pages/Notifications.vue';
import NotificationDetail from  '@/pages/NotificationDetail.vue';
import Promotions from  '@/pages/Promotions.vue';
import PromotionDetail from  '@/pages/PromotionDetail.vue';
import Auctions from  '@/pages/Auctions.vue';
import AuctionDetail from  '@/pages/AuctionDetail.vue';
import Reports from  '@/pages/Reports.vue';
import ReportDetail from  '@/pages/ReportDetail.vue';
import Subscriptions from  '@/pages/Subscriptions.vue';
import SubscriptionDetail from  '@/pages/SubscriptionDetail.vue';
import Invoices from  '@/pages/Invoices.vue';
import InvoiceDetail from  '@/pages/InvoiceDetail.vue';
import ShippingInfos from  '@/pages/ShippingInfos.vue';
import ShippingInfoDetail from  '@/pages/ShippingInfoDetail.vue';
import ReturnRequests from  '@/pages/ReturnRequests.vue';
import ReturnRequestDetail from  '@/pages/ReturnRequestDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/users',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/users',
		name: 'Users',
		layout: DefaultLayout,
		component: Users,
	},
	{
	    path: '/user/:userId', 
	    name: 'UserDetail',
		layout: DefaultLayout,
	    component: UserDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/items',
		name: 'Items',
		layout: DefaultLayout,
		component: Items,
	},
	{
	    path: '/item/:itemId', 
	    name: 'ItemDetail',
		layout: DefaultLayout,
	    component: ItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bids',
		name: 'Bids',
		layout: DefaultLayout,
		component: Bids,
	},
	{
	    path: '/bid/:bidId', 
	    name: 'BidDetail',
		layout: DefaultLayout,
	    component: BidDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/categorys',
		name: 'Categorys',
		layout: DefaultLayout,
		component: Categorys,
	},
	{
	    path: '/category/:categoryId', 
	    name: 'CategoryDetail',
		layout: DefaultLayout,
	    component: CategoryDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/feedbacks',
		name: 'Feedbacks',
		layout: DefaultLayout,
		component: Feedbacks,
	},
	{
	    path: '/feedback/:feedbackId', 
	    name: 'FeedbackDetail',
		layout: DefaultLayout,
	    component: FeedbackDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/addresss',
		name: 'Addresss',
		layout: DefaultLayout,
		component: Addresss,
	},
	{
	    path: '/address/:addressId', 
	    name: 'AddressDetail',
		layout: DefaultLayout,
	    component: AddressDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orders',
		name: 'Orders',
		layout: DefaultLayout,
		component: Orders,
	},
	{
	    path: '/order/:orderId', 
	    name: 'OrderDetail',
		layout: DefaultLayout,
	    component: OrderDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/shoppingCarts',
		name: 'ShoppingCarts',
		layout: DefaultLayout,
		component: ShoppingCarts,
	},
	{
	    path: '/shoppingCart/:shoppingCartId', 
	    name: 'ShoppingCartDetail',
		layout: DefaultLayout,
	    component: ShoppingCartDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/shoppingCartItems',
		name: 'ShoppingCartItems',
		layout: DefaultLayout,
		component: ShoppingCartItems,
	},
	{
	    path: '/shoppingCartItem/:shoppingCartItemId', 
	    name: 'ShoppingCartItemDetail',
		layout: DefaultLayout,
	    component: ShoppingCartItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/watchlists',
		name: 'Watchlists',
		layout: DefaultLayout,
		component: Watchlists,
	},
	{
	    path: '/watchlist/:watchlistId', 
	    name: 'WatchlistDetail',
		layout: DefaultLayout,
	    component: WatchlistDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/messages',
		name: 'Messages',
		layout: DefaultLayout,
		component: Messages,
	},
	{
	    path: '/message/:messageId', 
	    name: 'MessageDetail',
		layout: DefaultLayout,
	    component: MessageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/notifications',
		name: 'Notifications',
		layout: DefaultLayout,
		component: Notifications,
	},
	{
	    path: '/notification/:notificationId', 
	    name: 'NotificationDetail',
		layout: DefaultLayout,
	    component: NotificationDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/promotions',
		name: 'Promotions',
		layout: DefaultLayout,
		component: Promotions,
	},
	{
	    path: '/promotion/:promotionId', 
	    name: 'PromotionDetail',
		layout: DefaultLayout,
	    component: PromotionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/auctions',
		name: 'Auctions',
		layout: DefaultLayout,
		component: Auctions,
	},
	{
	    path: '/auction/:auctionId', 
	    name: 'AuctionDetail',
		layout: DefaultLayout,
	    component: AuctionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/reports',
		name: 'Reports',
		layout: DefaultLayout,
		component: Reports,
	},
	{
	    path: '/report/:reportId', 
	    name: 'ReportDetail',
		layout: DefaultLayout,
	    component: ReportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/subscriptions',
		name: 'Subscriptions',
		layout: DefaultLayout,
		component: Subscriptions,
	},
	{
	    path: '/subscription/:subscriptionId', 
	    name: 'SubscriptionDetail',
		layout: DefaultLayout,
	    component: SubscriptionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/invoices',
		name: 'Invoices',
		layout: DefaultLayout,
		component: Invoices,
	},
	{
	    path: '/invoice/:invoiceId', 
	    name: 'InvoiceDetail',
		layout: DefaultLayout,
	    component: InvoiceDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/shippingInfos',
		name: 'ShippingInfos',
		layout: DefaultLayout,
		component: ShippingInfos,
	},
	{
	    path: '/shippingInfo/:shippingInfoId', 
	    name: 'ShippingInfoDetail',
		layout: DefaultLayout,
	    component: ShippingInfoDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/returnRequests',
		name: 'ReturnRequests',
		layout: DefaultLayout,
		component: ReturnRequests,
	},
	{
	    path: '/returnRequest/:returnRequestId', 
	    name: 'ReturnRequestDetail',
		layout: DefaultLayout,
	    component: ReturnRequestDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
