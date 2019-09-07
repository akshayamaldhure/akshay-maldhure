# android-tests
This repository contains some UI tests for GnuCash Android app.

## Test cases proposed for automation
#### Custom accounts
| Scenario | Category | Expected condition |
| -------- | -------- | ------------------ |
| Complete setup with custom account option | Setup | The setup should take the user to the Accounts page and no pre-created accounts should be seen. |
| Create a custom account | Account Creation | The created account should be seen on the Accounts page. |
| Edit a custom account - update name | Account Actions | The edited account should show the updated name on the Accounts page. |
| Mark the account as favorite | Account Actions | The account marked as favorite should be in the Favorites tab. |
| Delete a custom account | Account Actions | The deleted account should not be seen on the Accounts page. |

#### Default accounts
| Scenario | Category | Expected condition |
| -------- | -------- | ------------------ |
| Complete setup with default accounts option | Setup | The setup should take the user to the Accounts page and the default accounts should be seen. |
| Add a new transaction to one of the default accounts | Account Actions | The created transaction should be seen in the Transactions tab. |
| Edit the transaction amount | Account Actions | The edited transaction should show the updated amount in the Transactions tab. |
| Duplicate the transaction | Account Actions | A new copy of the duplicated transaction should be seen in the Transactions tab. |
| Delete the transaction | Account Actions | The deleted transaction should not be seen in the Transactions tab. |

## Tech stack
1. Java 8
2. Maven
3. TestNG
4. Appium

## Pre-requisites
1. Android SDK Tools must be installed on your system. Please refer to the instructions provided [here](https://developer.android.com/studio?pkg=tools) for installation.
2. Appium must installed on your system. Please refer to the instructions provided [here](http://appium.io/docs/en/about-appium/getting-started/) for installation.
3. Android emulator must be up and running before running any tests. Please refer to the instructions provided [here](https://developer.android.com/studio/run/emulator-commandline) for the same.

## Running the tests
`mvn clean compile test`


