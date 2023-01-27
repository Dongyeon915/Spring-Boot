// 자바스크립트 객체를 가져오는 getElementById
// console.log(document.getElementById("title"));
// console.log(document instanceof HTMLDocument);

// 메소드를 정의할때는 function으로 시작된다
// function sayHello(){
//   // DOM객체를 가져온후 ID NAME에 .VALUE로 입력된 값을 콘솔로 확인
// .VALUE는 input으로 사용
//   console.log(document.getElementById("name").value);
// }

function sayHello(){
  var name = document.getElementById("name").value;
  var message = "<h2>Hello" + name + "!</h2>";
  // textContent로 텍스트 값을 넣어줄수 있음
  // document.getElementById("content").textContent = message;
  // HTML로 해석해서 값을 넣어줄때 innerHTML
  document.getElementById("content").innerHTML = message;
}