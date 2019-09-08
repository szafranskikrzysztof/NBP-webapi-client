# NBP-Web-API-client

NBP-Web-API-client is java powered application made as a simple web-service-client example.



### Usage



| Class | description |
| ------ | ------ |
| RestClient | connects with web services and provides user with method "getUSDCurrencyTable" which allows user to get exchange rate data in a form of ExchangeTable class. Data are obtained for period from given date to current date. Due to NBP-web-api restrictions given date can't be more than 367 days before current day. |
|ExchangeTable | stores general currency info and day by day exchange rate list. Data is represented by fields of the class and can be easly accessed by getters.|
|Rates| stores exchange rate data for single day.


### Example



For quick data preview toString method may be used. See example below:
```sh
 LocalDate givenDate = LocalDate.now().minus(Period.ofDays(4));
 CurrencyTable currencyTable = RestClient.INSTANCE.getUSDCurrencyTable(givenDate);
 System.out.println(currencyTable.toString());
```
Results will look something like this:
```sh
2019-09-04{bid=3.9442, ask=4.0238, bid change=null, ask change=null}
2019-09-05{bid=3.9038, ask=3.9826, bid change=-0.0404, ask change=-0.0412}
2019-09-06{bid=3.8745, ask=3.9527, bid change=-0.0293, ask change=-0.0299}
```
For first day of period bid and ask change from previous day are not displayed.


### Tech

Application uses:
* Jackson - to deserialize data from web-api
* Junit 
* Lombok

Local date deserializer is based on solution posted by Christopher Yang
https://stackoverflow.com/questions/28802544/java-8-localdate-jackson-format
