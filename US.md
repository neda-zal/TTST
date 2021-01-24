# USER STORIES
Sample file for MD user stories
-----------------------------------
| AUCTION CLASS
-----------------------------------
| -Incorrect bid (checkPriceValidity)
	-As a user I want to know if the price I bid for the item I want to buy is not enough
	
| -Is the auction still open?(checkTimeValidity)
	-As a user I want to know if the auction I want to bid for is still open
	
| -Is the auction started? (hasStarted)
	-As a user I want to check if the auction I am interested in has already started

| -Expired (hasExpired)
	-As a user I want to check if the auction I am interested in has expired

|
----------------------------------
| ITEM CLASS	
----------------------------------
| -Add Auction (addAuction)
 	-As a user I want to create an auction for my item.
 		
|
----------------------------------
| SELLER CLASS
----------------------------------	     
| -Add one item to the system (addItem)
	-As an user I want to add my item to the system so that I can sell it. I don't want to sell it for to less so I want to decide how much the minimum bid has to be. I also want to make sure that everyone has a good idea of 	it so I want to show photos of it and I also want to make sure people can 	find it so I want to add it the correct category.

| -Modify my item in the system (modifyItem)
	-As a seller I already registered my amazing action figure in the system, 	but yesterday the same action figure was sold for much more than what I am 	asking so I want to change the price and the minimum bid.

| -Create auction (createAuction)
	-As a user I want to sell my ancient unique book, which is really 	expensive. I want to create an auction for it and I want to decide the 	starting price, the starting time and for how long the auction can go to 	increase the possibilities to earn good money from it.

|
---------------------------------
| USER CLASS
---------------------------------
| -Registration (register)
	-as Davide I have a really rare fossil and I want to try to sell it on 	this website thus I 	want to register to try selling it with a username and a password.
	
| -Placing a bid (placeBid)
	-As Marco there is an auction going on for a special old map for a treasure and I absolutely want it. I want to place a bid to try to win the auction

| -Loggin in (login)
	-As a User I want to log in into my account so I can start bidding for a auction I am 	interested in. Logging in could also help me to see the list of auctions I am interest in and 	all my personal data.
	
| -Research (searchAuction)
	-As Marco I am collecting all the fabergè eggs and I am missing only one. I need to check on 	this system if someone is selling it and if yes, when the auction is going to be, and what 	the starting price will be. 
	
	                                       
| ------------------------------------------------------------|
 
| # ACCEPTANCE TEST
-----------------------------------
| AUCTION CLASS
-----------------------------------
| -Incorrect bid test(checkPriceValidity)
	-checkPriceValidity(10), knowing that the previous price was 5.
	(If the offered price is higher than the last bid, the bid will be accepted.)
		-return true;
	
| -Is the auction still open? (transformed in hours:min) test(checkTimeValidity)
	-Starting time: 9:00
	-current time: 12:35
	-Auction closing time: 12:30
		-return false;
		-(since the current time is > than the auction closing time, the auction is not open 		anymore)
	 
	
| -Open auction (transformed in hours:min) test (hasStarted)
	-starting time: 12:30
	-current time: 12:35;
		-return true; 
		-(since the current time is greater than the auction opening time, the auction has started. 		The condition to return true is that the current time must be greater than the starting 		time)

| -Expired (transformed in hours:min) test (hasExpired)
	-ending time: 12:30
	-current time: 12:35;
		-return true; 
		-(since the current time is greater than the auction closing time, the auction has 		finished. The condition to return true is that the current time must be greater than the 		ending time)

|
----------------------------------
| ITEM CLASS	
----------------------------------
| -Add Auction test (addAuction)
 	-addAuction("SuperAuction")
 	-the auction will be added if this auction is not present in the system already and neither 	the item.
 		
|
----------------------------------
| SELLER CLASS
----------------------------------	     
| -Add one item to the system test(addItem)
	-addItem("amazing old bible",100,bible.png,4)
		The method will return true since the description is not empty, is shorter than 200 		character, the bid increment is higher than 0 and the categoryId is higher than 0.

| -Modify my item in the system test(modifyItem)
	-modifyItem(5221,"amazing old bible with special characters",200,bible.png,4)
		The method will let the user modify the item since the specific item was already in the 		system and thus it will return true. The condition is that to modify an item is necessary 		that that item is already in the system.
		The modified item changed in the following way:
			-description: amazing old bible --> amazing old bible with special characters
			-bidIncrement: 100 --> 200
			-image did not change
			-cathegoryid did not change

| -Create auction test(createAuction)
	-createAuction(4,2000,9:00,12:30)
	The function will return true since the item is present in the system and it will create an 	auction starting at 9:00 and ending at 12:30 with a starting price of 2000.

|
---------------------------------
| USER CLASS
---------------------------------
| -Registration test(register)
	-register(dfilippi,password)
		Since the username wasn't regitered into the system, it's not empty and the password is not 		empty the function will return true and will register the user into the system with the 		following parameters:
		-username: dfilippi
		-password: password
	
| -Placing a bid test (placeBid)
	-placeBid(1, 125)
	This function will return true since the auction with the id "1" exist, it has started, hasn't 	ended yet and the previous bid was 100. The system will place a bid of 125 to the auction with 	id 1

| -Loggin in test (login)
	-login(dfilippi,password)
	This function will return true since this account has been already registered.
	The user will login into the dfilippi account since the inserted credentials are correct.
	The condition for this method to login is to insert correct and corresponding credentials.
	
| -Research test (searchAuction)
	-searchAuction(4,books,2000,10000,9:00,12:30) 
	This function will return true since there is an auction registered with these specifications.
	The condition for this method to return something is to search for an auction that actually exists 	on the system.                                     | 
