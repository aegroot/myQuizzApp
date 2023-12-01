

function fetchData(link){
 return fetch("http://localhost:8080/api/v1/"+link,{method:"get"})

}
function fetchPost(link,data){
   return fetch("http://localhost:8080/api/v1/"+link,
   {method:"post", body:JSON.stringify(data),headers:{
    "content-type":"application/json"
   }})

}
export default {fetchData,fetchPost}