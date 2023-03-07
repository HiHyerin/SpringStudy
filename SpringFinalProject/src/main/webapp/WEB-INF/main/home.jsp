<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="wrapper row3">
  <div id="slider" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="flexslider basicslider">
      <ul class="slides">
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back1.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back2.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back3.jpg" style="width:978px;height:400px"></a></li>
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </div>
</div>

<div class="wrapper row3 rows">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <ul class="nospace group btmspace-80">
      <li class="one_third first">
        <article class="service"><i class="icon fa fa-ambulance"></i>
          <h6 class="heading"><a href="#">오늘의 레시피</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-h-square"></i>
          <h6 class="heading"><a href="#">오늘의 뉴스</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-hospital-o"></i>
          <h6 class="heading"><a href="#">오늘의 날씨</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
    </ul>
    <!-- ################################################################################################ -->
    <h2 class="sectiontitle">믿고 보는 맛집 리스트</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <li v-for="(vo,index) in cate_list" v-if="index>=0 && 12>index">
          <figure><img class="radius-10 btmspace-10" :src="vo.poster" alt="">
            <figcaption><a :href="'../food/food_list.do?cno='+vo.cno">{{vo.title}}</a></figcaption>
          </figure>
        </li>
       
      </ul>
    </div>
    <h2 class="sectiontitle">지역별 인기 맛집</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <li v-for="(vo,index) in cate_list" v-if="index>=12 && 18>index">
          <figure><img class="radius-10 btmspace-10" :src="vo.poster" alt="">
            <figcaption><a :href="'../food/food_list.do?cno='+vo.cno">{{vo.title}}</a></figcaption>
          </figure>
        </li>
      </ul>
    </div>
    <h2 class="sectiontitle">메뉴별 인기 맛집</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <li v-for="(vo,index) in cate_list" v-if="index>=18 && 30>index">
          <figure><img class="radius-10 btmspace-10" :src="vo.poster" alt="">
            <figcaption><a :href="'../food/food_list.do?cno='+vo.cno">{{vo.title}}</a></figcaption>
          </figure>
        </li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
    <h2 class="sectiontitle">추천 맛집과 레시피</h2>
    <!-- ################################################################################################ -->
    <ul class="nospace group">
      <li class="one_half first">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
      <li class="one_half">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
    </ul>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div style="height: 30px"></div>
    <h2 class="sectiontitle">최근 방문 맛집</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <li v-for="vo in cookie_list" >
          <figure><a :href="'../food/food_detail.do?fno='+vo.fno"><img class="radius-10 btmspace-10" :src="vo.poster" alt=""></a>
            <figcaption><a :href="'../food/food_detail.do?fno='+vo.fno">{{vo.name}}</a></figcaption>
          </figure>
        </li>
      </ul>
    </div>
    <h2 class="sectiontitle">최근 방문 레시피</h2>
    <div class="clear"></div>
  </main>
</div>
<script>
  new Vue({
     el:'.rows',
     data:{
        cate_list:[],
        cookie_list:[]
     },
     mounted:function(){
        let _this=this;
        axios.get("http://localhost:8080/web/food/food_main_vue.do").then(function(response){
           console.log(response.data)
           _this.cate_list=response.data
        })
        axios.get("http://localhost:8080/web/food/cookie_data_vue.do").then(function(response){
           _this.cookie_list=response.data
        })
     }
  })
</script>
</body>
</html>