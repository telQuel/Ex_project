let url = "http://localhost:8080/api/robots";

let systemsList;

document.querySelector('.mainHeader').innerHTML = "Hello JS";

method();

// setInterval(() => {
//     method(url);
// }, 10000);

function method() {
    $.ajax({
        url: url,         /* Куда пойдет запрос */
        method: 'get',             /* Метод передачи (post или get) */
        dataType: 'json',           /* Тип данных в ответе (xml, json, script, html). */
        cache: false,          
        success:
                function (returnData) {
                    let arrTh = ["NameRobot", "Date Take To Work", "deadline", "status", "FIO Developer"];
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
                                    td.innerHTML = systemsList[i].robotName; //systemsList[i].get()
                                    break;
                                case 1:
                                    td.innerHTML = systemsList[i].dateTakeToWork; //systemsList[i].get()
                                    break;
                                case 2:
                                    td.innerHTML = systemsList[i].deadline;
                                    break;
                                case 3:
                                    td.innerHTML = systemsList[i].status;
                                    break;
                                case 4:
                                    td.innerHTML = systemsList[i].fioDeveloper;
                                    break;
                                case 5:
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

