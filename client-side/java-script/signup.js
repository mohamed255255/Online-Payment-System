const emailInput = document.querySelector('#email');
const passwordInput = document.querySelector('#password');
const repeatedPasswordInput = document.querySelector('#repeated-password');
const phoneNumberInput = document.querySelector('#phone-number');
const signUpForm = document.querySelector('#signup-form');

signUpForm.addEventListener('submit', (e) => {
   e.preventDefault();

   const email = emailInput.value;
   const RepeatedPassword =repeatedPasswordInput.value;
   const password = passwordInput.value;
   const phoneNumber = phoneNumberInput.value;

   const data = {
      email: email,
      password: password,
      phonenumber: phoneNumber
   };
   
   fetch('http://localhost:8080/QuickPay/signup', {
      method: 'POST',
      headers: {
         'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
   })
   .then(response => {
      if (!response.ok) {
         throw new Error('Network response was not ok');
      }
      return response;
   })
   .then(response => {
      console.log(response);
      alert('You have successfully signed up!');
   })
   .catch(error => {
      console.error('Error signing up:', error);
      alert('An error occurred while signing up. Please try again later.');
   });
});