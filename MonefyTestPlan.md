# Monefy Android app - Test plan

This is a test plan document for the Monefy Android app. The test cases are organised in various categories and are ordered according to the priority (business impact) below (Priority-0 being the highest). The test cases from a given category may span across different priority sections.

### Priority-0 (App launch/close)

| Scenario | Category | Validation |
| -------- | -------- | ------------|
| App launch | App launch/close | The app should launch successfully from the Android launcher. |
| App close | App launch/close | The app should be closed gracefully after pressing the Back button on Android from the app home screen. |
| Clear the app from recents | App launch/close | The app should be closed gracefully without any crashes. |
| Resume the app from recents | App launch/close | The app should resume from where the user left off. This behaviour may vary on certain devices, e.g. on those on which the Android system behaves aggressively on the background apps by killing them. |

### Priority-1 (Creating and viewing expenses and incomes)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Create an expense using the EXPENSE button | Expense creation | The user should be able to create an expense by tapping on the EXPENSE button and the same should be visible on the Balances screen under the chosen category. |
| Create an expense using the Category button | Expense creation | The user should be able to create an expense by tapping on any of the category buttons on the home screen and the expense should be visible on the Balances screen under the chosen category. |
| Create an income using the INCOME button | Income creation | The user should be able to create an income by tapping on the INCOME button and the same should be visible on the Balances screen under the chosen category. |
| Create an expense without selecting the category | Expense creation | The expense should not be created. |
| Create multiple expenses/incomes of the same category | Expense/income creation | The user should be able to create multiple expenses/incomes of the same category and the counts next to such categories in the balances list should be seen accordingly. |
| View expenses and incomes using the Balances button | Home page | The user should be able to view their expenses and incomes by tapping on the Balances button on the home screen. |
| View expenses and incomes on the donut chart | Home page | The user should be able to view their expenses and incomes by tapping on the donut chart on the home screen. |
| Switch between the summary view and balances list view | Home page | The user should be able to switch between these two views by tapping on the Balances button or the hamburger menu buttons present on the either sides of the Balances button. |
| Filter records - View by account | Filters | With expenses/incomes added from different accounts, the user should be able to view the records based on the account. |
| Filter records - View by duration | Filters | With the expenses/incomes added from different times like a specific date, week, month, year, the user should be able to view the records according to the duration filter applied. By default, the month filter should be applied. |
| Long press on a category to view the total expenses of that category within the selected duration | View expenses | The user should be able to view the expenses belonging to a specific category by long tapping on its icon on the home screen. |

### Priority-2 (Updating, cancelling, deleting expenses and incomes)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Edit an expense - add a note | Expense editing |  The user should be able to add a note to the expense and the updated note should be seen on opening the expense again. |
| Edit an expense - change amount | Expense editing |  The user should be able to change the expense amount by using the backspace button and the updated amount should be reflected on the Balances screen. |
| Edit an expense - change amount to decimal number | Expense editing |  The user should be able to change the expense amount to a decimal number and the updated amount should be reflected on the Balances screen. |
| Edit an expense - change date | Expense editing | The user should be able to change the date of an expense and the updated date should be seen on the Balances screen. |
| Edit an expense - change category | Expense editing | The user should be able to change the category of an expense and it should be visible under the updated category on the Balances screen. |
| Edit an expense - change payment type | Expense editing | The user should be able to change the payment type of an expense and the updated payment type should be seen on opening the expense again. |
| Cancel a created expense | Expense creation | The user should be able to cancel an expense by tapping on the Cancel button right after they create it. Any cancelled expense should not be seen on the Balances screen. |
| Cancel a created income | Income creation | The user should be able to cancel an income by tapping on the Cancel button right after they create it. Any cancelled income should not be seen on the Balances screen. |
| Delete an expense from the Balances screen | Expense deletion | The user should be able to delete a created expense by tap-and-hold the expense and clicking on the Delete button on the Balances screen and the same should not be visible on the Balances screen post deletion. |
| Delete an expense from the expense screen | Expense deletion | The user should be able to delete a created expense by tapping on the Delete icon on the expense screen and the same should not be visible on the Balances screen post deletion. |
| Delete multiple expenses/incomes at once | Delete expenses/incomes | The user should be able to long tap and select multiple records, and delete them. |

### Priority-3 (Calculations)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Balances amount calculation | Home page | The balances amount should be calculated as (total of all the incomes - total of all the expenses)|
| Total expenses on home page | Home page | The home page should show the total of all the expenses added by the user. |
| Total income on home page | Home page | The home page should show the total of all the incomes added by the user. |
| Calculation functions | Expense creation | Various calculation functions addition, subtraction, multiplication, division should work as expected. |

### Priority-4 (Categories and accounts)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Custom categories for expense and income | Categories | The user should be able to add custom expense and income categories by tapping on the 3-dot menu button -> Categories. |
| Add an expense under a custom category | Categories | The user should be able to add a new expense under a custom category. |
| Add an income under a custom category | Categories | The user should be able to add a new income under a custom category. |
| Add a custom account | Accounts | The user should be able to add a custom account (e.g. Debit card). The user should then be able to add expenses/incomes, transfer account from/to the custom account. |
| Transfer amount from Cash and Payment Card and vice-versa from the home page | Accounts | The user should be able to transfer amount across the Cash and Payment Card accounts by tapping on the Transfer button on the top right on the home screen. |
| Transfer amount from Cash and Payment Card and vice-versa from the 3-dot menu | Accounts | The user should be able to transfer amount across the Cash and Payment Card accounts by tapping on the 3-dot menu -> Transfer button. |

### Priority-5 (UI behavior)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Home page header | UI | The home page header should be seen as per the duration filter, e.g. If "Month" is selected, the header should be set to the current month (like "September"). |
| Expenses on the home page and balances list | UI | All the expense amounts and the Create Expense button should be seen in RED color. |
| Incomes on the home page and balances list | UI | All the income amounts and the Create Income button should be seen in GREEN color. |
| Carry Over amount on the home page | UI | This amount should be seen in BLUE color. |
| Tapping on any of the category icons on the home page | UI | The icon background should be highlighted in it's respective color. |
| Dark Mode | UI | The user should the entire app UI in dark/grey/black colors with the Dark Mode enabled. |

### Priority-6 (Pro version features - should be prioritised based on the number of users across each of the version types)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Purchase the Pro version | Features | The user should be taken to the Play Store payment page on tapping on any of the Pro version features, like Dark Mode, Passcode Protection, Google Drive/Dropbox synchronisation, etc. |
| Free version vs Pro version features | Features | Accessibility of the app pro features should be available/unavailable based on whether the user has purchased the Pro version. |

### Priority-7 (Free version features - should be prioritised based on the number of users across each of the version types)
| Scenario | Category | Validation |
| -------- | -------- | ------------|
| Use the app in Budget Mode | App settings | With the Budget Mode enabled and the budget set, the user should be able to view the budget in blue colour on the home screen. |
| Negative value for budget | App settings | The user should not be able to enter a negative value for the budget. |
| Enable the Carry over feature | App settings | With the Carry Over setting enabled, the user should be able to view the carried over amount on the home screen. |
| Change app language | App settings | The user should be able to view various text labels throughout the app based on the language chosen through settings. |
| Change currency | App settings | The user should be able to view various amounts throughout the app based on the currency chosen through settings. |
| Change first day of the week/month | App settings | The user should be able to filter and view the expenses/incomes as per the week and month as per the first day of the week/month set. |
| Export records to a file - deny permission | App settings | The user should not be able to export all the records in a file and the app should not crash. |
| Export records to a file - allow permission | App settings | The user should be able to export all the records in a file and upload it to any of the available options. |
| Create data backup | Data backup | The user should be able to create a backup of all the records and the same should be saved in the phone storage. |
| Create/restore data backup - cross version compatibility | Data backup | The user should be able to create a backup of all the records on one version of the app and the they should be able to take the backed up data file and restore it on another different version of the app. |
| Restore from backed up data | Data backup | The user should be able to restore the data from a previously created backup file. |
| Clear all the data | Data backup | The user should be able to clear all the records and no data should be seen in the app thereafter. |