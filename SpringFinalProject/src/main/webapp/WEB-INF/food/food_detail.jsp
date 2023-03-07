<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="wrapper row3 rows">
  	  <main class="container clear">
  	  	<div class="row">
  	  		<table class="table">
  	  		  <tr>
  	  		    <td v-for="img in food_detail.poster.split('^')">
  	  		    	<img :src="img" style="width: 100%">
  	  		    </td>
  	  		  </tr>
  	  		</table>
  	  	</div>
  	  	<div style="height: 20px"></div>
  	  	<div class="two_third first">
  	  		<table class="table">
  	  		  <tr>
  	  		    <td colspan="2">
  	  		    	<h3><span id="name">{{food_detail.name}}</span>&nbsp;<span style="color:orange">{{food_detail.score}}</span></h3>
  	  		    </td>
  	  		  </tr>
  	  		  <tr>
  	  		  	<th width=20%>주소</th>
  	  		  	<td width=80%>
  	  		  		{{food_detail.addr1}}<br>
  	  		  		<sub>지번:{{food_detail.addr2}}</sub>
  	  		  	</td>
  	  		  </tr>
  	  		  <tr>
  	  		  	<th width=20%>전화</th>
  	  		  	<td width=80%>{{food_detail.tel}}</td>
  	  		  </tr>
  	  		  <tr>
  	  		  
  	  		  	<th width=20%>음식종류</th>
  	  		  	<td width=80%>{{food_detail.type}}</td>
  	  		  </tr>
  	  		  <tr>
  	  		  	<th width=20%>가격대</th>
  	  		  	<td width=80%>{{food_detail.price}}</td>
  	  		  </tr>
  	  		  <tr>
  	  		  	<th width=20%>영업시간</th>
  	  		  	<td width=80%>{{food_detail.time}}</td>
  	  		  </tr>
  	  		  <tr>
  	  		  	<th width=20%>주차</th>
  	  		  	<td width=80%>{{food_detail.parking}}</td>
  	  		  </tr>
  	  		  <tr>
  	  		  	<th width=20%>메뉴</th>
  	  		  	<td width=80%>
  	  		  		<ul>
  	  		  			<li v-for="m in food_detail.menu.split('원')">{{m}}원</li>
  	  		  		</ul>
  	  		  	</td>
  	  		  </tr>
  	  		  <tr>
  	  		    <td colspan="2" class="text-right">
  	  		      <a href="javascript:history.back()" class="btn btn-xs btn-danger">목록</a>
  	  		    </td>
  	  		  </tr>
  	  		</table>
  	  	</div>
        <div class="one_third">
        	<div id="map" style="width:100%;height:350px;"></div>
        </div>
  	  </main>
  	</div> 
  	
<script>
	new Vue({
		el:'.rows',
		data:{
			fno:${fno},
			food_detail:{},
			count:0
		},/* 바로 나와야할 때 mounted, 버튼클릭하면 나와야 할 때 methods */
		mounted:function(){
			let _this = this
			axios.get("http://localhost:8080/web/food/food_detail_vue.do",{
				params:{
					fno:_this.fno
				}
			}).then(function(response){
				console.log(response.data)
				_this.food_detail=response.data
				if(window.kakao && window.kakao.maps){
					_this.initMap();
				}else{
					_this.addScript();
				}
				
			})
		},
		methods:{
			addScript:function(){
				const script = document.createElement("script")
				/* global kakao */
				script.onload=()=>kakao.maps.load(this.initMap)
				script.src='http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=474ea1f30b292f1e0644ae92fbff2778&libraries=services'
				document.head.appendChild(script)
			},
			
			initMap:function(){
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(this.food_detail.addr1, function(result, status) {

			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {

			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });

			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
			        });
			        infowindow.open(map, marker);

			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});  
			}
			  
			
		}
	})
</script>
</body>
</html>