# CLI Tests

## User input functionality to test (valid cases)
Commands:
- M <n>
- L
- R
- P
- I <n>
- U
- D
- C
- Q

Assert the correct value in getCommand and getValue
Test lower and upper case commands

## User input functionality (invalid cases)
- M or I but no number (Invalid)
- M or I but negative number
- Number by itself
- Letters not associated with a command
- Nothing (blank line)

Assert the correct value in getCommand (Unknown or Invalid depending on case)