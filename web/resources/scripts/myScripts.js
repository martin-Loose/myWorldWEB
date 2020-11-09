/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myAlert(){
    alert("test ");   
     let inputVal = document.getElementById('userTable:j_idt28').value;
    alert("test "+ inputVal);    
}
function login(id){
      var modal = document.getElementById('login');

        // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            };
}
 
      function getInputValue() {
        // Selecting the input element and get its value 
         let inputVal = document.getElementById("requester").value;
          alert(inputVal);
        let inputVal = document.getElementsByClassName("inputClass")[0].value;
        // Displaying the value
        alert(inputVal);
      }
    
  // Get the modal
          
