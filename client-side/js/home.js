		// Get the dropdown button and content
		var dropdownButton = document.querySelector(".dropdown-button");
		var dropdownContent = document.querySelector(".dropdown-content");

		// Add a click event listener to the dropdown button
		dropdownButton.addEventListener("click", function() {
			// Toggle the display of the dropdown content
			if (dropdownContent.style.display === "block") {
				dropdownContent.style.display = "none";
			} else {
				dropdownContent.style.display = "block";
			}
		});





		///////////live search 

		//localhost:8080/QuickPay/search?servicename=vodafone adsl

    const resultsList = document.getElementById('results-list');

    function search(query) {
      if (query.length > 0) {
        fetch(`http://localhost:8080/QuickPay/search?servicename=${encodeURIComponent(query)}`)
          .then(function(response) {
            return response.json();
          })
          .then(function(results) {
            resultsList.innerHTML = '';
            if (results.length === 0) {
              document.getElementById('search-results').style.display = 'none';
              }else{
              document.getElementById('search-results').style.display = 'block';
              results.forEach(function(result) {


                const listItem = document.createElement('li');
                const link = document.createElement("a");
                const img = document.createElement("img");
                
                link.textContent = result.servicename;
                img.src=`/${result.img_path}`;
                listItem.setAttribute('role' , 'button');
                listItem.addEventListener('click', function() {
                  window.location.href = `/${result.serviceId}`; 
                });
                listItem.appendChild(link);
                listItem.appendChild(img);
                resultsList.appendChild(listItem);

                
              });
            }
          })
          .catch(function(error) {
            console.error(error);
          });
      } else {
        resultsList.innerHTML = '';
        document.getElementById('search-results').style.display = 'none';
      }
    }
    
    const searchInput = document.getElementById('search-input');
    searchInput.addEventListener('input', function(event)
    {
    const query = event.target.value.toLowerCase();
    search(query);
    });