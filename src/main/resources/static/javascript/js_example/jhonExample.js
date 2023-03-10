// DOMContentLoaded란 이벤트 파일이 로딩될때 하단 function이벤트가 실행된다.
document.addEventListener("DOMContentLoaded", function (event) {
      // 어떤 이벤트인지 확인이 가능하다
      console.log("[DOMContentLoaded]", event);
      console.log("Type:", event.type);
      // HTMLDoument -> JavaScript Object
      // DOM(Document Object Model) - DOM API
      // 자바스크립트 객체를 는주어들만 getElementById
      const titleEL = document.getElementById("title");
      titleEL.classList.add("my-title")
      console.log(titleEL)
      console.log("Type: ", typeof titleEL);
      // console.log(document instanceof HTMLDocument);
      // 메소드를 정의할때는 function으로 시작된다
      // function sayHello(){
      // DOM객체를 가져온후 ID NAME에 .VALUE로 입력된 값을 콘솔로 확인
      // VALUE는 input으로 사용
      // console.log(document.getElementById("name").value);
      const arrowFunction01 = () => {
        console.log("Hello Arrow Function!")
      }
      arrowFunction01()

      const nameEL = document.getElementById("name");
      nameEL.setAttribute("type", "password");

      nameEL.addEventListener('keydown', (e) => {
        // 이벤트는 내부에 계속
        if (e.code.startsWith("Digit")) {
          // alert("Password Error!")
          e.preventDefault();
        } else {
          console.log(e.key)
        }
      });



      // 뭔가 event 정보를 얻고 싶다면 콜백 인자를 넣어서 확인이 가능 없으면 해당 태그가 나옴.
      function sayHello(event) {
        event.preventDefault()
        setTimeout(()=>{
          console.log("WOW")
        }, 3000)
        console.log("[Button]", event)
        // this는 하단 클릭시 발생하는 addEventListener를 의미함
        console.log(this);
        var name = document.getElementById("name").value;
        nameEL.setAttribute("type", "text")
        nameEL.classList.toggle("visible")
        var message = "<h2>Hello" + name + "!</h2>";
        // textContent로 텍스트 값을 넣어줄수 있음
        // document.getElementById("content").textContent = message;
        // HTML로 해석해서 값을 넣어줄때 innerHTML
        document.getElementById("content").innerHTML = message
        if (name === "student") {
          // getElementById는 페이지 내에서 id로 선택에 제약이 있으므로 css 셀렉터인 querySelector를 사용
          // querySelector로 인한 #title
          var title = document.querySelector("#title").textContent;
          title += " & LOVE It";
          // 명시적으로 어떤값이 입력될지를 = 를통해 넣어준다.
          document.querySelector("#title").textContent = title;
        }
      }

      // HTML과 이벤트를 분리해서 HTML은 어떤 이벤트가 있는지 알수없음
      document.querySelector("button").addEventListener("click", sayHello);
      //  새로운 이벤트 작성시에도 틀에 맞춰서 작성할수있다
      document.querySelector("body").addEventListener("mousemove", (event) => {
            if (event.shiftKey === true) {
              console.log("x: " + event.clientX);
              console.log("Y: " + event.clientY);
            }
          })
    }
);
