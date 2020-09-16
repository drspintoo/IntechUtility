###### Coding Exercise

You are working for a company called "Initech" on a web service with your coworker "Bill".  Bill just sent you an email that the customer contact field on the company's website is saving personal customer information in the clear.  The contact field on the website has the label "**Email or Phone**" with a character length of 80 and the data is not validated on the front end. Bill has said the email domain does not have to be masked, but the customer's email must be masked except for the first and last character. Bill said for phone numbers we need to mask the middle three digits and leave everything else in the clear. Bill says he wants a simple utility method he can pass this field and get a masked result back for the database. Bill also needs to see lots of test proof that this method works. Bill just left for a vacation to Brazil, so document any assumptions that you think Bill would agree with.

--------

###### Assumptions

-If the customer contact cannot be masked (i.e. : Cannot be validated as an email of phone number. ) 'null' will be returned.

-If the customer contact contains the '@' sign then it is assumed to represent an email address and the domain address is the portion that follows (on the right side of) the '@' sign.

-The domain address will not be validated.

-If the customer contact is determined to be an email address then the left portion of the string, preceding the '@' sign, that will be masked, should have a length greater than two (2) otherwise the entire left portion of the email (1 or 2 positions) will be masked.

-Domain Names will not be validated for Email Address.

-Phone Number will be assumed as US 10-digit phone number that can optionally contain phone number format characters along with digits.

-Phone Number format characters will be stripped prior to masking.

-For Phone Numbers "mask the middle three digits" it is assumed that this refers to the second set of three digits of a US 10-digit phone number.

-The mask character will be asterisk '*'.

