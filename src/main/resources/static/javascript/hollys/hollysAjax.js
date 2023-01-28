document.addEventListener("DOMContentLoaded", () => {
  const btnEl = document.querySelector("#id-btn");
  const idEl = document.querySelector("#id-input");
  console.log(btnEl);
  btnEl.addEventListener("click", () => {
    // 비동기 실행으로 순서가 없이 실행된다.
    getCategoryByID(idEl.value)
    getAllCategory()
  });

  document.querySelector("#all-id").addEventListener("click", (e) => {
    // e.preventDefault()
    getAllCategory();
    setCategory();
  });

  function setCategory() {
    $.ajax("http://192.168.1.140:8080/category/setCategory", {
          method: "POST",
          dataType: "json",
          contentType: "application/json",
          data: JSON.stringify({
            category_id: null,
            menu_fk: 1,
            type: "바닐라딜롸이트"
          })
        }
    ).done((data, textStatus, jqXHR) => {
      console.log(data);
    }).fail((jqXHR, textStatus, errorThrown) => {
      console.log(errorThrown);
    });
  }

  function getAllCategory() {
    $.getJSON("http://192.168.1.140:8080/category", null,
        (data, textStatus, jqXHR) => {
          console.log(data);
          let categoryList = "";
          data.map((eachData, index) => {
            console.log(`[${index
            + 1} 번] ID: ${eachData.category_id}, Type: ${eachData.type}`)
            categoryList += `<h5>[${index
            + 1} 번] ID: ${eachData.category_id}, Type: ${eachData.type}</h5>`
          })
          // const allCategoryEL = document.querySelector(".all-category")
          // allCategoryEL.innerHTML = categoryList
          // console.log(categoryList)
        });
  }

  function getCategoryByID(id) {
    $.ajax(`http://192.168.1.140:8080/category/${id}`, {
      contentType: "application/JSON"
    }).done(function (data, textStatus, jqXHR) {
      console.log(data);
      console.log(textStatus);
      const dangerEL = document.querySelector("p.category-empty")
      if (dangerEL.classList.contains("danger")) {
        dangerEL.classList.toggle("danger")
      }
      dangerEL.innerText = `입력하신 ID ${data.category_id}ㄴㄴ의 타입은 ${data.type}입니다.`
    }).fail(function (jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
      const dangerEL = document.querySelector("p.category-empty")
      if (!dangerEL.classList.contains("danger")) {
        dangerEL.classList.toggle("danger")
      }
      dangerEL.innerText = "No Category!"
    });
  }
});

