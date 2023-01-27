const REST_API_KEY = "sadkjaslkjflkajsflkjasldjaslkjaslkdjlasjdlk"
const url = 'http://localhost:8080/dongs/set/controller';

const settings = {
  method: "POST",
  contentType: "application/json",
  data: null,
  headers: {
    "my-secret": "fuck them",
    "Authorization": `KakaoAK ${REST_API_KEY}`
  }
}

const nameInput = document.querySelector("#name-input")
const ageInput = document.querySelector("#age-input")
const userSearchBtn = document.querySelector(".user-info-btn")

// function noArrow() {
//   console.log(nameInput.value, ageInput.value)
//   settings.data = JSON.stringify({
//     name: nameInput.value,
//     age: ageInput.value
//   })
//   getUser()
// }
//
// userSearchBtn.addEventListener('click', noArrow)

userSearchBtn.addEventListener('click', () => {
  console.log(nameInput.value, ageInput.value)
  settings.data = JSON.stringify({
    name: nameInput.value,
    age: ageInput.value
  })
  getUser()
})

function getUser() {
  $.ajax(url, settings)
  .done((data, statue) => {
    console.log("success")
    console.log(data);
    console.log(data.name, data.age)
    const nameEL = document.querySelector(".name")
    const ageEL = document.querySelector(".age")
    nameEL.innerText = data.name
    ageEL.innerText = data.age
  }).fail((jqXHR, textStatus, errorThrown) => {
    console.log("Fail")
    console.log("jqXHR: ", jqXHR)
    console.log(jqXHR.status)
    console.log("textStatus:", textStatus)
    console.log("errorThrown", errorThrown)});
}


