webpackJsonp([1],{KelY:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),r={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var o=n("VU/8")({name:"App"},r,!1,function(t){n("P4bt")},null,null).exports,c=n("/ocq"),s=n("mtWM"),i=n.n(s),u={name:"Webtoon",data:function(){return{webtoons:{webtoonList:[],webtoonListEnd:[],mytoken:""},msg:"webtoon 목록 보여주기"}},mounted:function(){this.getWebtoon(),localStorage.name&&(this.mytoken=localStorage.name)},watch:{mytoken:function(t){localStorage.name=t}},methods:{getWebtoon:function(){var t=this;i.a.get("/api/getWebtoon").then(function(e){return t.webtoons=e.data})},getImageResource:function(t){return"/webtoonImage/"+t+".png"},showAlert:function(){alert("투표 안됨")}}},l={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"webtoon"},[n("h1",[t._v(t._s(t.msg))]),t._v(" "),n("table",[t._l(t.webtoons.webtoonList,function(e){return n("tr",[n("td",[t._v(t._s(e.webtoon_name))]),t._v(" "),n("td",[n("a",{attrs:{href:"/api/vote/"+e.webtoon_no}},[n("img",{attrs:{src:t.getImageResource(e.webtoon_name),width:"150",height:"150"}})])])])}),t._v(" "),t._l(t.webtoons.webtoonListEnd,function(e){return n("tr",[n("td",[t._v(t._s(e.webtoon_name))]),t._v(" "),n("td",[n("img",{attrs:{src:t.getImageResource(e.webtoon_name),width:"150",height:"150"},on:{click:function(e){t.showAlert()}}})])])})],2)])},staticRenderFns:[]};var d=n("VU/8")(u,l,!1,function(t){n("lYQd")},"data-v-7034ef90",null).exports,h={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"characters_wrapper"},[n("h1",[t._v(t._s(t.introduce))]),t._v(" "),n("div",{staticClass:"register_form_wrap"},[n("form",{attrs:{action:"./register/character",method:"post",enctype:"multipart/form-data"}},[n("input",{attrs:{type:"hidden",name:"webtoon_name"},domProps:{value:this.$route.params.webtoon}}),t._v(" "),t._m(0),t._v(" "),t._m(1)])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"button_group"},[e("input",{staticClass:"button",attrs:{type:"submit",value:"후보 등록"}})])},function(){var t=this.$createElement,e=this._self._c||t;return e("table",{staticClass:"form_table"},[e("tr",[e("td",{staticStyle:{width:"100px"}},[this._v("\n\t\t\t\t    \t이름\n\t\t\t    \t")]),this._v(" "),e("td",[e("input",{staticStyle:{width:"99%"},attrs:{type:"text",name:"character_name",placeholder:"이름을 입력하세요.(최대길이 20)",maxlength:"20"}})])]),this._v(" "),e("tr",[e("td",{staticStyle:{width:"100px"}},[this._v("\n\t\t\t\t    \t이미지\n\t\t\t    \t")]),this._v(" "),e("td",[e("input",{attrs:{type:"file",name:"character_image",accept:"image/*"}})])])])}]};var m=n("VU/8")({name:"RegisterMember",data:function(){return{introduce:"Register Member"}},created:function(){this.$route.params.webtoon}},h,!1,function(t){n("KelY")},null,null).exports,p={name:"Characters",data:function(){return{characters:void 0,webtoon:null}},created:function(){this.webtoon=this.$route.params.webtoon},mounted:function(){var t,e=this,n=new SocJS("./stomp"),a=Stomp.over(n);a.connect({},function(){var n="/subscribe/"+e.webtoon+"/characters";a.subscribe(n,function(t){e.characters=t.body}),t=setInterval(function(){a.send("/publish/"+e.webtoon+"/characters",{},null)},1e3)}),a.onclose=function(){clearInterval(t)}},methods:{getCharacters:function(){var t=this;i.a.get("./api/"+this.$route.params.webtoon+"/characters").then(function(e){return t.characters=e.data})}}},v={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"characters_wrapper"},t._l(t.characters,function(e){return n("div",{key:e.character_no},[t._v("\n        "+t._s(e.character_name)+" + '/' + "+t._s(e.count)+"\n    ")])}))},staticRenderFns:[]};var f=n("VU/8")(p,v,!1,function(t){n("qdW1")},null,null).exports,_={name:"Grpah",data:function(){return{webtoon:void 0}},created:function(){this.webtoon=this.$route.params.webtoonId},mounted:function(){var t,e=this,n=new SockJS("./stomp"),a=Stomp.over(n);a.debug=function(){};var r=960-90-30,o=500-16-85;a.connect({},function(){var n="/subscribe/"+e.webtoon+"/characters";a.subscribe(n,function(t){$("#graph_wrapper").empty();var e=JSON.parse(t.body),n=d3.format(".0%"),a=d3.scale.ordinal().rangeRoundBands([100,r-20],.1),c=d3.scale.linear().range([o-20,20]),s=d3.svg.axis().scale(a).orient("bottom"),i=d3.svg.axis().scale(c).orient("left").tickFormat(n),u=d3.scale.category10();d3.json("",function(t){t=e,t=d3.keys(e).map(function(e){return{character_name:t[e].character_name,count:Number(t[e].count)}});var r=d3.sum(t,function(t){return t.count});a.domain(t.map(function(t){return t.character_name})),c.domain([0,d3.max(t,function(t){return t.count/r})]),u.domain(t.map(function(t){return t["이름"]}));var l=d3.select("#graph_wrapper").append("svg").attr("width",960).attr("height",500),d=(l.append("g").attr("class","x axis").attr("transform","translate(0, "+o+")").style({stroke:"black",fill:"none","stroke-width":"1px"}).call(s),l.append("g").attr("class","y axis").attr("transform","translate(100,20)").style({stroke:"black",fill:"none","stroke-width":"1px"}).call(i),l.selectAll("rect").data(t));d.enter().append("rect").attr("class","bar").attr("x",function(t){return a(t.character_name)}).attr("width",a.rangeBand()),d.attr("y",function(t){return c(t.count/r)}).attr("height",function(t){return o-c(t.count/r)}),d.attr("fill",function(t,e){return u(e)}),l.selectAll(".label").data(t).enter().append("text").attr("class","label").attr("text-anchor","middle").style("font-size","20px").style("font-weight","bold").attr("font-family","sans-serif").text(function(t){return n(t.count/r)}).attr("x",function(t){return a(t.character_name)+a.rangeBand()/2}).attr("y",function(t){return c(t.count/r)}).attr("dy","0.9em")})}),t=setInterval(function(){a.send("/publish/"+e.webtoon+"/characters",{},null)},3e3)}),a.onclose=function(){clearInterval(t)}},methods:{}},b={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{attrs:{id:"graph_wrapper"}})},staticRenderFns:[]},w=n("VU/8")(_,b,!1,null,null,null).exports,g=n("mvHQ"),y=n.n(g),x={name:"test",data:function(){return{msg:"vue",name:[]}},created:function(){this.getWebtoonName()},methods:{getWebtoonName:function(){var t=this;return i.a.get("api/webtoonList").then(function(e){return t.name=e.data})},addCharacter:function(){console.log(this.webtoonId),console.log(this.characterName);var t=new FormData;t.append("webtoonId",this.webtoonId),t.append("characterName",this.characterName),i.a.post("api/webtoonList",t).then(function(t){console.log("response : ",y()(t,null,2))}).catch(function(t){console.log("failed",t)})}}},I={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"hello"},[n("h1",[t._v(t._s(t.msg))]),t._v(" "),n("h2",[t._v("character add")]),t._v(" "),n("select",{directives:[{name:"model",rawName:"v-model",value:t.webtoonId,expression:"webtoonId"}],on:{change:function(e){var n=Array.prototype.filter.call(e.target.options,function(t){return t.selected}).map(function(t){return"_value"in t?t._value:t.value});t.webtoonId=e.target.multiple?n:n[0]}}},t._l(t.name,function(e){return n("option",{domProps:{value:e.webtoon_vote_no}},[t._v(t._s(e.webtoon_name))])})),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.characterName,expression:"characterName"}],attrs:{type:"text"},domProps:{value:t.characterName},on:{input:function(e){e.target.composing||(t.characterName=e.target.value)}}}),t._v(" "),n("button",{on:{click:t.addCharacter}},[t._v("추가")]),t._v(" "),n("a",{attrs:{href:"api/vote"}},[t._v("들어가기")])])},staticRenderFns:[]};var k=n("VU/8")(x,I,!1,function(t){n("dTUF")},"data-v-45005098",null).exports,C={name:"characterVote",data:function(){return{msg:"vue",name:[],characters:void 0,webtoon:null,total:null}},created:function(){this.getCharacName(),this.getTotal(),this.webtoon=this.$route.params.webtoonId},mounted:function(){var t,e=this,n=new SockJS("./stomp"),a=Stomp.over(n);a.debug=function(){},a.connect({},function(){var n="/subscribe/"+e.webtoon+"/characters";a.subscribe(n,function(t){var e=JSON.parse(t.body);$.each(e,function(t,n){$(this).html(e[index].count)})}),t=setInterval(function(){a.send("/publish/"+e.webtoon+"/characters",{},null)},1e3)}),a.onclose=function(){clearInterval(t)}},methods:{getCharacName:function(){var t=this;return i.a.get("api/vote/"+this.$route.params.webtoonId).then(function(e){return t.name=e.data})},getTotal:function(){var t=this;return i.a.get("api/total/"+this.$route.params.webtoonId).then(function(e){return t.total=e.data})},printText:function(){console.log("received an event")},vote:function(){console.log(this.$route.params.webtoonId),console.log(characterId.value);var t=new FormData;t.append("characterId",characterId.value),i.a.post("api/vote/"+this.$route.params.webtoonId,t).then(function(t){console.log("response : ",y()(t,null,2))}).catch(function(t){console.log("failed",t)})}}},N={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("table",{attrs:{id:"character_table"}},[n("h1",[t._v(" character~~")]),t._v(" "),n("div",{staticClass:"timeout_wrapper"}),t._v(" "),n("characterVoteLow",{on:{"show-log":t.printText}}),t._v(" "),t._l(t.name,function(e,a){return n("tr",{key:e.character_no},[n("td",a<2?{staticClass:"character_count"}:{staticClass:"character_count",attrs:{colspan:"2"}},[t._v("\n      "+t._s(e.count)+"\n    ")]),t._v(" "),n("td",[t._v(t._s(e.character_name))]),t._v(" "),n("td",[n("button",{attrs:{name:"characterId",id:"characterId",value:e.character_no},on:{click:t.vote}},[t._v("vote")])])])})],2)])},staticRenderFns:[]},S=n("VU/8")(C,N,!1,null,null,null).exports;a.a.use(c.a);var R=new c.a({routes:[{path:"/",name:"Webtoon",component:d},{path:"/:webtoon/characters",name:"Characters",component:f},{path:"/:webtoon/register",name:"RegisterMember",component:m},{path:"/api/vote/:webtoonId",name:"characterVote",component:S},{path:"/api/graph/:webtoonId",name:"Graph",component:w},{path:"/api/vote/:webtoonId",name:"characterVote",component:S},{path:"/api/webtoonList",name:"characterRegister",component:k},{path:"/api/vote/:webtoonId",name:"characterVote",component:S}]});a.a.config.productionTip=!1,a.a.prototype.$http=i.a,new a.a({el:"#app",router:R,components:{App:o},template:"<App/>"})},P4bt:function(t,e){},dTUF:function(t,e){},lYQd:function(t,e){},qdW1:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.c06695da7bade20c4ff1.js.map