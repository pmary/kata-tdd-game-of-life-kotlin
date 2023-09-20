# Kata TDD: The Game of Life in Kotlin, step by step

Read the tutorial at [pierremary.com](https://pierremary.com/).

## Commit convention
In order to show how you might TDD something, I made a commit for every RED / GREEN / REFACTOR tasks. This way, the commit log tell the story of the code.  

There are three main types of commits:  
- 'red' after a failing test/part-test;
- 'green' when that test/part passes, and
- 'refactor' when changes are made to improve the code's quality along the lines of DRY, the single responsibility principle and other such guidelines.

Commits alternate between 'red' and 'green', with optional (though highly-recommended) refactorings after a 'green' commit. It helps, particularly when performing a test-/behaviour-driven development kata, for the commit messages to tell a story (and for their summary lines to be clear and concise, so they can be quickly read).