# android-tests
This repository contains some UI tests for GnuCash Android app.

## Test cases proposed for automation
As adding and maintaining the UI-level tests is expensive with respect to the execution time and maintenance costs ([refer to the Test Pyramid](https://martinfowler.com/bliki/TestPyramid.html)), this test suite contains a minimal set of critical end-to-end UI-based tests. The test cases are organised in various categories and are ordered according to the priority (business impact) below. The test cases from a given category may span across different priority sections. For the most part, calculations should happen at unit and/or integration test layers and end-to-end journeys should be tested at the UI layer.

#### Custom accounts
| Scenario | Category | Expected condition | Automation notes |
| -------- | -------- | ------------------ | ---------------- |
| Complete setup with custom account option | Setup | The setup should take the user to the Accounts page and no pre-created accounts should be seen. | Added |
| Create a custom account | Account Creation | The created account should be seen on the Accounts page. | Added |
| Edit a custom account - update name | Account Actions | The edited account should show the updated name on the Accounts page. | Added |
| Mark the account as favorite | Account Actions | The account marked as favorite should be in the Favorites tab. | Added |
| Delete a custom account | Account Actions | The deleted account should not be seen on the Accounts page. | Added |
| Search for an account | Account Actions | The account being searched for should be shown on the Accounts page. | Not a critical feature, no tests added |

#### Default accounts
| Scenario | Category | Expected condition | Automation notes |
| -------- | -------- | ------------------ | ---------------- |
| Complete setup with default accounts option | Setup | The setup should take the user to the Accounts page and the default accounts should be seen. | Added |
| Add a sub account in a default account | Account Actions | The user should be able to add sub accounts in any of the default accounts | No tests added |
| Add a new transaction to one of the default accounts | Account Actions | The created transaction should be seen in the Transactions tab. | Added |
| Split transaction amount across different transactions | Account Actions | The user should be able to split the transaction amount into multiple transactions. | Long flow, no tests added |
| Navigate to another sub account from the title bar | Navigation | The user should be able to navigate from one sub account to another from the title bar for easy access. | No tests added | 
| Delete a sub account from a default account | Account Actions | The user should be able to delete sub accounts from any of the default accounts | No tests added |
| Delete the transaction | Account Actions | The deleted transaction should not be seen in the Transactions tab. | Added |

#### App features
| Scenario | Category | Expected condition | Automation notes |
| -------- | -------- | ------------------ | ---------------- |
| View expense reports | Features | The user should be able to view a report of his expenses in the form of a pie chart. | Not a critical feature. Difficult to validate pie chart programmatically, no tests added |
| View scheduled actions | Features | The user should be able to view all the scheduled transactions at one place. | Not a critical feature, no tests added |
| Export transactions | Features | The user should be able to export all the transactions in formats like CSV, QIF, XML. | Feature rarely used by users. Difficult to test import and export of transactions programmatically, no tests added |
| Enable passcode | Features | The user should be able to enable passcode for secure access to the app. | No tests added |
| Manage books | Features | The user should be able to manage their books containing all the accounts and transactions. | Feature rarely used by users. Difficult to test import and export of transactions programmatically, no tests added |
| View app info | About | The user should be able to view the app info in the About section. | Not a critical feature, no tests added |
| Send feedback | About | The user should be able to send the feedback about the app to the developers. | Not a critical feature, rarely used by users, no tests added |

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


