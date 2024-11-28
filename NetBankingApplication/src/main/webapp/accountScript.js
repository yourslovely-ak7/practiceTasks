// Function to display accounts
function displayAccounts(accounts) {
    const accountsContainer = document.getElementById('accounts-container');
    accountsContainer.innerHTML = ''; // Clear any existing accounts

    accounts.forEach(account => {
        // Create a div for each account box
        const accountBox = document.createElement('div');
        accountBox.classList.add('account-box');

        // Account title
        const accountTitle = document.createElement('h2');
        accountTitle.textContent = `Account #${account.accountNumber}`;
        accountBox.appendChild(accountTitle);

        // Account details
        const accountDetails = document.createElement('div');
        accountDetails.classList.add('account-details');

        const accountType = document.createElement('div');
        accountType.innerHTML = `<span>Account Type:</span> ${account.accountType}`;
        accountDetails.appendChild(accountType);

        const balance = document.createElement('div');
        balance.innerHTML = `<span>Balance:</span> ${account.balance}`;
        accountDetails.appendChild(balance);

        const createdDate = document.createElement('div');
        createdDate.innerHTML = `<span>Created Date:</span> ${account.createdDate}`;
        accountDetails.appendChild(createdDate);

        const branch = document.createElement('div');
        branch.innerHTML = `<span>Branch:</span> ${account.branch}`;
        accountDetails.appendChild(branch);

        // Append the details to the account box
        accountBox.appendChild(accountDetails);

        // Append the account box to the container
        accountsContainer.appendChild(accountBox);
    });
}

// Fetch the account data from the backend
async function fetchAccountData() {
	
	const response= await fetch('/NetBankingApplication/getAccounts', {
	            method: 'GET',
	            headers: { 'Content-Type': 'application/json' },
	        });
	        
	const data = await response.json();
			
	if (data && Array.isArray(data.accounts)) 
	{
	    displayAccounts(data.accounts);  // Display the accounts on the page
	}
	else
	{
    	console.error('Invalid data structure received from backend');
	}		
}

// Call the fetchAccountData function to get and display the accounts
fetchAccountData();
