<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	margin: 0px auto;
	width: 800px;
}

.h1{
	text-align: center
}
.clickTr:hover{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<h1>일일 박스오피스</h1>
		<div class="row">
			<table class="table">
			 <thead>
			  <tr>
			  	<th class="text-center">순위</th>
			  	<th class="text-center"></th>
			  	<th class="text-center">영화명</th>
			  	<th class="text-center">감독</th>
			  	<th class="text-center">장르</th>
			  </tr>
			 </thead>
			 <tbody>
			 	<tr v-for="(vo, index) in movie_list" v-on:click="detail(index)" class="clickTr">
			 		<td class="text-center">{{vo.rank}}</td>
				  	<td class="text-center">
				  		<img :src="'https://www.kobis.or.kr/'+vo.thumbUrl" width="30" height="30">
				  	</td>
				  	<td>{{vo.movieNm}}</td>
				  	<td>{{vo.director}}</td>
				  	<td>{{vo.genre}}</td>
			 	</tr>
			 </tbody>
			</table>
			<table class="table">
				<tr v-for="name in names.split(',')">
				  <td>{{name}}</td>
				</tr>
			</table>
		</div>
		<div id="dialog" title="영화상세보기" style="display:none">
			<table class="table">
				<tr>
				  <td width=30% class="text-center" rowspan="7">
				  	<img :src="'https://www.kobis.or.kr/'+movie_detail.thumbUrl" style="width: 100%">
				  </td>
				  <td colspan="2"><b>{{movie_detail.movieNm}}</b></td>
				</tr>
				<tr>
				  <td width=20% class="text-right">감독</td>
				  <td width=50%>{{movie_detail.director}}</td>
				</tr>
				<tr>
				  <td width=20% class="text-right">장르</td>
				  <td width=50%>{{movie_detail.genre}}</td>
				</tr>
				<tr>
				  <td width=20% class="text-right">개봉일</td>
				  <td width=50%>{{movie_detail.startYearDate}}</td>
				</tr>
				<tr>
				  <td width=20% class="text-right">순위</td>
				  <td width=50%>{{movie_detail.rank}}</td>
				</tr>
				<tr>
				  <td width=20% class="text-right">등급</td>
				  <td width=50%>{{movie_detail.watchGradeNm}}</td>
				</tr>
				
			</table>
			<table class="table">
				<tr>
				  <td colspan="3" height="200" class="text-left" valign="top">{{movie_detail.synop}}</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 
		VO = {} => Object (JSONObject) => {"키":값}
		List = [{}, {}, {}, {}, ...] => Array(JSONArray)
	 -->
	 <!-- 
	 	data:{
	 		1. 목록
	 			movie_list[],
	 		2. 객체
	 			movie_detail:{}
	 		3. 문자열
	 			names:''
	 		4. 숫자
	 			number:0, 0.0..
	 		5. boolean
	 			isShow:false
	 		
	 	}
	  -->
	<script>
	  new Vue({
		  el:'.container',
		  data:{
			movie_list:[{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20230533","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_64254284e5f449e691c23f244ec5d67b.jpg","movieNm":"귀멸의 칼날: 상현집결, 그리고 도공 마을로","movieNmEn":"Demon Slayer: Kimetsu no Yaiba -To the Swordsmith Village-","synop":"혈귀가 숨어있는 거리에 잠입한 탄지로 일행.\r\n강력한 상현 6 혈귀 남매 규타로 & 다키와의 전투 끝에 탄지로 일행은 궁지에 몰린다.\r\n절체절명 위기의 순간에도 흔들리지 않는 곧은 의지로\r\n규타로에 맞서는 탄지로, 젠이츠, 이노스케 그리고 음주 우즈이 텐겐.\r\n환락의 거리 속 혈귀를 쓰러트리기 위한 그들의 치열한 전투가 시작된다. \r\n\r\n한편, 키부츠지 무잔은 무한성에 상현 혈귀들을 소집시키고\r\n탄지로는 새로운 칼을 찾아 도공 마을로 향하는데...","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"109","showTs":"48","director":"소토자키 하루오","prNm":null,"dtNm":"(주)디스테이션","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"15세이상관람가","openDt":"20230302","salesAmt":817896200,"audiCnt":64955,"scrCnt":261,"showCnt":928,"rank":1,"rankInten":-1,"rankOldAndNew":"NEW","rownum":1},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20208962","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_67727deb988e4eb0b88ae2f9b8cf5c93.jpg","movieNm":"대외비","movieNmEn":"The Devil's Deal","synop":"“몰랐나? 원래 세상은 더럽고, 인생은 서럽다.” \r\n1992년 부산, 밑바닥 정치 인생을 끝내고 싶은 만년 국회의원 후보 ‘해웅’. \r\n‘해웅’은 이번 선거에서만큼은 금뱃지를 달 것이라 확신했지만, \r\n정치판을 뒤흔드는 권력 실세 ‘순태’에게 버림받으며 지역구 공천에서 탈락한다. \r\n\r\n“누가 센 지는 손에 뭘 쥐고 있는가 보라 안 했습니까?”\r\n‘순태’에 의해 짜여진 선거판을 뒤집기 위해 부산 지역 재개발 계획이 담긴 대외비 문서를 입수한 ‘해웅’. \r\n행동파 조폭 ‘필도’를 통해 선거 자금까지 마련한 ‘해웅’은 무소속으로 선거판에 뛰어들어 승승장구한다. \r\n‘순태’ 역시 ‘해웅’이 가진 대외비 문서의 존재를 알게 되고, 점차 ‘해웅’의 숨통을 조여오는데…\r\n\r\n대한민국을 뒤집을 비밀 문서, \r\n이 판을 뒤집는 놈이 대한민국을 뒤집는다!","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"115","showTs":"46","director":"이원태","prNm":"(주)트윈필름,(주)비에이엔터테인먼트","dtNm":"플러스엠 엔터테인먼트","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"범죄,드라마","watchGradeNm":"15세이상관람가","openDt":"20230301","salesAmt":434699768,"audiCnt":47051,"scrCnt":991,"showCnt":4024,"rank":2,"rankInten":-1,"rankOldAndNew":"OLD","rownum":2},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20230495","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_a09a805520a14a39aa592272a0eb435c.jpg","movieNm":"아임 히어로 더 파이널","movieNmEn":"IM HERO THE FINAL","synop":"2022년 겨울 고척스카이돔을 뜨겁게 달궜던 ‘아임 히어로(IM HERO)’ 임영웅의 앵콜 콘서트, \r\n그 대단원의 감동을 재현할 <아임 히어로 더 파이널>이 스크린X로 2023년 관객들을 찾아온다.\r\n\r\n“제가 마치 트루먼 쇼의 주인공이 된 것 같아요”\r\n\r\n자신이 영화 ‘트루먼 쇼’의 주인공이 된 것 같다고 말하지만, \r\n그러면서도 팬덤 ‘영웅시대’를 위해 매 순간 혼신의 힘을 다하는 ‘현실 임영웅’의 모습과 \r\n진심 어린 인터뷰, 영화에서만 만나볼 수 있는 전국 투어 비하인드 스토리까지.\r\n\r\n14대 시네마틱 카메라로 촬영해 오직 극장에서만 볼 수 있는 앵글로 \r\n특별한 관람 경험을 선사할 임영웅의 <아임 히어로 더 파이널>\r\n\r\n지금 극장에서 만나보세요. \r\n","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"102","showTs":"0","director":"오윤동","prNm":"씨제이포디플렉스 주식회사","dtNm":"씨제이포디플렉스 주식회사,CGV ICECON","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"공연,다큐멘터리","watchGradeNm":"전체관람가","openDt":"20230301","salesAmt":404833000,"audiCnt":16873,"scrCnt":132,"showCnt":555,"rank":3,"rankInten":1,"rankOldAndNew":"OLD","rownum":3},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20228555","showDt":"20230302","thumbUrl":"/common/mast/movie/2022/12/thumb/thn_de3eb9d23b1b49e58b5f06b96d5fa6b5.jpg","movieNm":"더 퍼스트 슬램덩크","movieNmEn":"The First Slam Dunk","synop":"전국 제패를 꿈꾸는 북산고 농구부 5인방의 꿈과 열정, 멈추지 않는 도전을 그린 영화","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"124","showTs":"26","director":"이노우에 다케히코","prNm":null,"dtNm":"(주)넥스트엔터테인먼트월드(NEW)","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"12세이상관람가","openDt":"20230104","salesAmt":144899938,"audiCnt":14191,"scrCnt":612,"showCnt":1799,"rank":4,"rankInten":-2,"rankOldAndNew":"OLD","rownum":4},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20239573","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_1c8dbd5fdf4e4d5c95eca3785757f1ca.jpg","movieNm":"서치 2","movieNmEn":"Missing","synop":"여행을 끝내고 월요일 귀국을 알린 엄마의 영상통화\r\n그리고 마중 나간 딸\r\n그러나 엄마가 사라졌다\r\n\r\n경찰에 도움을 요청하지만, 결정적인 단서들이 나오지 않는 가운데\r\n딸 ‘준’은 엄마의 흔적을 찾기 위해\r\n엄마가 방문한 호텔의 CCTV, 같이 간 지인의 SNS, \r\n거리뷰 지도까지 온라인에 남아있는 모든 흔적을 검색하는데…\r\n\r\n이번에는 딸이 사라진 엄마의 흔적을 검색하다!","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"110","showTs":"32","director":"니콜라스 D 존슨,윌 메릭","prNm":null,"dtNm":"소니픽쳐스엔터테인먼트코리아주식회사극장배급지점","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"미스터리,스릴러","watchGradeNm":"12세이상관람가","openDt":"20230222","salesAmt":94941564,"audiCnt":11070,"scrCnt":596,"showCnt":1274,"rank":5,"rankInten":1,"rankOldAndNew":"OLD","rownum":5},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20230209","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_3614a2a28006422db60207f4d9332791.jpg","movieNm":"앤트맨과 와스프: 퀀텀매니아","movieNmEn":"Ant-Man and the Wasp: Quantumania","synop":"슈퍼히어로 파트너인 '스캇 랭'(폴 러드)과 '호프 반 다인'(에반젤린 릴리),\r\n호프의 부모 '재닛 반 다인'(미셸 파이퍼)과 '행크 핌'(마이클 더글라스), \r\n그리고 스캇의 딸 '캐시 랭'(캐서린 뉴튼)까지 \r\n미지의 '양자 영역' 세계 속에 빠져버린 '앤트맨 패밀리'.\r\n\r\n그곳에서 새로운 존재들과 무한한 우주를 다스리는 정복자 '캉'을 만나며,\r\n그 누구도 예상 못한 모든 것의 한계를 뛰어넘는 모험을 시작하게 되는데… \r\n\r\n2023년 첫 번째 마블 블록버스터\r\n2월, 무한한 우주의 정복자가 깨어난다!","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"124","showTs":"24","director":"페이튼 리드","prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션","watchGradeNm":"12세이상관람가","openDt":"20230215","salesAmt":96689601,"audiCnt":10943,"scrCnt":598,"showCnt":1668,"rank":6,"rankInten":-3,"rankOldAndNew":"OLD","rownum":6},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20193706","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_ec559fa6c22c4b0fb6ee0038da3dcb05.jpg","movieNm":"카운트","movieNmEn":"Count","synop":"마이웨이, 오직 직진!\r\n한번 물면 절대 놓지 않는 킹받는 美친 개가 온다!\r\n\r\n1988년 올림픽 금메달리스트지만\r\n1998년 지금은 평범한 고등학교 선생인 ‘시헌’(진선규).\r\n선수 생활 은퇴 후 남은 건 고집뿐,\r\n모두를 킹받게 하는 마이웨이 행보로 주변 사람들의 속을 썩인다.\r\n\r\n그러던 어느 날, 우연히 참석한 대회에서 뛰어난 실력에도 불구하고\r\n승부 조작으로 기권패를 당한 ‘윤우’(성유빈)를 알게 된 ‘시헌’은\r\n복싱부를 만들기로 결심한다.\r\n아내 ‘일선’(오나라)의 열렬한 반대와, ‘교장’(고창석)의 끈질긴 만류도 무시한 채,\r\n‘시헌’은 독기만 남은 유망주 ‘윤우’와\r\n영문도 모른 채 레이더망에 걸린 ‘환주’(장동주), ‘복안’(김민호)을 데리고\r\n본격적인 훈련에 돌입하기 시작하는데...!\r\n\r\n쓰리, 투, 원! 2023년 새해, 긍정 파워 풀충전!\r\n그들만의 가장 유쾌한 카운트가 시작된다\r\n","prdtYear":"2021","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"108","showTs":"57","director":"권혁재","prNm":"(주)필름케이,(주)26컴퍼니","dtNm":"(주)씨제이이엔엠","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"12세이상관람가","openDt":"20230222","salesAmt":66927625,"audiCnt":8421,"scrCnt":615,"showCnt":1297,"rank":7,"rankInten":0,"rankOldAndNew":"OLD","rownum":7},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20227684","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/01/thumb/thn_7dd851b1338b45af89a055369d4ab66c.jpg","movieNm":"멍뭉이","movieNmEn":"My Heart Puppy","synop":"\"'루니'의 새 집사를 찾아라!\"\r\n동생 같은 반려견 ‘루니’를 위해 정시 퇴근에 진심인 ‘민수’\r\n결혼을 앞둔 그에게 닥친 집사 인생 조기 로그아웃 위기!\r\n\r\n야심 차게 오픈한 카페는 말아먹고 인생 자체가 위기인 사촌형 '진국',\r\n'민수'의 다급한 SOS에 고심하다 새 집사 면접을 제안하게 되고.\r\n \r\n완벽한 집사를 찾기 위해 제주도로 향하는 두 형제의 여정에\r\n느닷없는 멍뭉이들의 등장이 이어지는데!\r\n\r\n뜻밖의 ‘견’명적인 만남\r\n함께 하면 개신나고! 개따뜻한!\r\n개귀엽 버라이어티 무비!","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"112","showTs":"45","director":"김주환","prNm":"(주)와이웍스엔터테인먼트,(주)돈키호테엔터테인먼트","dtNm":"(주)키다리스튜디오","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"전체관람가","openDt":"20230301","salesAmt":66308812,"audiCnt":7600,"scrCnt":533,"showCnt":1269,"rank":8,"rankInten":-3,"rankOldAndNew":"OLD","rownum":8},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20210684","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/01/thumb/thn_e3d5fcf6875943d0a0f1e5fdc8577736.jpg","movieNm":"두다다쿵: 후후섬의 비밀","movieNmEn":"Duda&Dada The Secret of HooHoo Island","synop":"“두다, 후후섬에 가면 엄마를 찾을 수 있을 거야!\"\r\n\r\n두다를 위해 친구들이 뭉쳤다!\r\n후후섬에 가기 위해서는 신비의 꽃, 빛나는 크리스털을 찾아야 해!\r\n우리 핑카 타고 모험을 떠나볼까?\r\n\r\n“우와! 전설의 눈토끼 마을에 도착했어!”\r\n\r\n뭐? 보름달이 뜰 때마다 용이 내려와 아기 토끼들을 데려간다고?\r\n용으로부터 아기 토끼들을 구하고\r\n후후섬에 가기 위한 보물들을 얻어야 해!\r\n\r\n다들 함께 할 준비됐지?\r\n다 함께 두다다다 출발 =3=3\r\n","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"83","showTs":"9","director":"최병선,김지윤","prNm":"아이스크림 스튜디오(주)","dtNm":"(주)넥스트엔터테인먼트월드(NEW)","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20230215","salesAmt":24979000,"audiCnt":3988,"scrCnt":188,"showCnt":210,"rank":9,"rankInten":0,"rankOldAndNew":"OLD","rownum":9},{"startYearDate":"2023.03.02","endYearDate":"2023.03.02","startDate":"2023년 03월 02일(목)","endDate":"2023년 03월 02일(목)","movieCd":"20202026","showDt":"20230302","thumbUrl":"/common/mast/movie/2023/02/thumb/thn_9af853f734834b03982502b6f8615f5d.jpg","movieNm":"마루이 비디오","movieNmEn":"Marui Video","synop":"국내에서 일어난 사건 영상 중 그 수위가 높아 외부로 유출되면 안 되는 영상물 '마루이 비디오'\r\n검찰청 지하 보관소에 봉인된 비디오에 대한 소문을 들은 김수찬 PD는 이를 입수해 다큐멘터리를 제작하기로 하는데…\r\n영상 속에 담긴 1992년 동성장 여관방 살인사건과 1987년 아미동 일가족 살인사건의 진실은 과연 무엇인가?","prdtYear":"2020","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"86","showTs":"57","director":"윤준형","prNm":"(주)발포플랜,(주)브라더픽처스","dtNm":"씨제이 씨지브이(CJ CGV)(주),(주)케이티알파","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"미스터리,공포(호러)","watchGradeNm":"15세이상관람가","openDt":"20230222","salesAmt":32385000,"audiCnt":3034,"scrCnt":211,"showCnt":384,"rank":10,"rankInten":-2,"rankOldAndNew":"OLD","rownum":10}],
	  		movie_detail:{},
	  		names:'홍길동, 이순신, 박문수, 강감찬, 김두한, 심청이, 춘향이, 콩쥐, 팥쥐'
		  },
		  methods:{
			  detail:function(index){
				  this.movie_detail = this.movie_list[index]; //멤버변수 가져올 땐 this.
				  $('#dialog').dialog({
					  autoOpen:false,
					  width:500,
					  height:550,
					  modal:true
				  }).dialog("open")
			  }
		  }
	  })
	</script>
</body>
</html>
