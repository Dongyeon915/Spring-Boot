const url = 'http://localhost:8080/views';
const settings = {
  method: "GET",
  dataType: "json",
}
$.ajax(url, settings).done((data, statue) => {
  console.log("success")
  console.log(data);
}).fail((jqXHR, textStatus, errorThrown) => {
  console.log("Fail")
  console.log("jqXHR: ", jqXHR)
  console.log(jqXHR.status)
  console.log("textStatus:", textStatus)
  console.log("errorThrown", errorThrown)
});