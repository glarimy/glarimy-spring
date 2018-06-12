HelloWorld Assignment on Spring Core:

Create a bank application with the following requirements:
1. To be able to open a new account for a customer whose name and phone number are mandatory
2. To be able to find balance of the newly created account
3. To be able to get full account details 

Account
	number
	balance
	customer: Customer
		name
		phoneNumber
		address: Address
			location
			city
			pincode
	transactions: Transaction
		date
		amount
		type
		balance