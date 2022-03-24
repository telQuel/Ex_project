let url = "http://192.168.3.2:34554/api/system/GetAllSystems";

let systemsList;

document.querySelector('.mainHeader').innerHTML = "Hello JS";

method();

// setInterval(() => {
//     method(url);
// }, 10000);

function method() {
    $.ajax({
        url: url,         /* Куда пойдет запрос */
        method: 'post',             /* Метод передачи (post или get) */
        dataType: 'json',           /* Тип данных в ответе (xml, json, script, html). */
        cache: false,          
        success:
                function (returnData) {
                    let arrTh = ["№", "СИСТЕМА", "ИЗМЕНИТЬ"];
                    systemsList = returnData;
                    let column = arrTh.length;
    
                    // Формирование заголовка таблицы
                    document.querySelector(".container").innerHTML = '<table class="body-content-table"></table><div class="scroll-table-body"></div>';
                    document.querySelector(".body-content-table").innerHTML = '<thead></thead>';
    
                    let tableTh = document.querySelector(".body-content-table thead");
                    let tr = document.createElement("tr");
    
                    for (let j = 0; j < column; j++) {
                        let th = document.createElement("th");
                        th.innerHTML = arrTh[j];
                        th.className = 'th_' + (j + 1);
                        tr.appendChild(th);
                    }
                    tableTh.appendChild(tr);
    
                    // Формирование строк таблицы
                    //document.querySelector(".container").innerHTML = '<div class="scroll-table-body"></div>';
                    document.querySelector(".scroll-table-body").innerHTML = '<table><tbody></tbody></table>';
    
                    let table = document.querySelector(".scroll-table-body tbody");
    
                    for (let i = 0; i < systemsList.length; i++) {
                        let tr = document.createElement("tr");
                        tr.className = 'body-content-table-tr';
    
                        for (let k = 0; k < column; k++) {
                            let td = document.createElement("td");
                            td.className = 'td_' + (k + 1);
    
                            switch (k) {
                                case 0:
                                    td.innerHTML = i + 1;
                                    break;
                                case 1:
                                    td.innerHTML = systemsList[i].systemName;
                                    break;
                                case 2:
                                    td.innerHTML = `<a href="#openModal-editSystem" class="section-btn nav-btn nav-btn-href" id="systemEdit_open" onclick="OpenEditSystem(this)" name="${i}";">ИЗМЕНИТЬ</a>`;
                                    break;
                            }
                            tr.appendChild(td);
                        }
                        table.appendChild(tr);
                    }
                },
            error: function () {
                alert("Произошел сбой обновления данных.");
            }
    });
}

