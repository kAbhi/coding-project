# Harbor Take Home Project

Welcome to the Harbor take home project. We hope this is a good opportunity for you to showcase your skills.

## The Challenge

Build us a REST API for calendly. Remember to support

- Setting own availability
- Showing own availability
- Finding overlap in schedule between 2 users

It is up to you what else to support.

## Expectations

We care about

- Q. Have you thought through what a good MVP looks like? Does your API support that?
- A. Yes. A good MVP supports functionalities as follows:
1. Create a user using name and email. Allow read, update and delete (CRUD operations).
2. Create user availability. Allow CRUD operations.
3. If the second user is registered and sets availability, provide a screen with overlap of their schedules.
4. If the second user is not registered, show them first user's availability to book a slot.

- Q. What trade-offs are you making in your design?
1. Timezone support : I'm focusing on building basic functionality so timezone support is not available.
2. Recurring events : Finding overlap in schedule has basic logic so recurring events is not supported.
3. Performance : I'm assuming small-scale implementation and logic is not optimised for large input.

- Q. Working code - we should be able to pull and hit the code locally. Bonus points if deployed somewhere.
- A. Code can be pulled and run locally. It needs Java 17 and runs locally using Spring boot. Code uses in-memory H2 database.
You can run the CalendlyApplication.java after cloning the repo.

- Q. Any good engineer will make hacks when necessary - what are your hacks and why?
1. In-Memory DB : Using an in-memory DB for MVP instead of setting up full DB.
2. Manual DTO mapping : Mapped the entity models with DTOs manually instead of using mapping library.

We don't care about

- Authentication
- UI
- Perfection - good and working quickly is better

It is up to you how much time you want to spend on this project. There are likely diminishing returns as the time spent goes up.

## Submission

Please fork this repository and reach out to Prakash when finished.

## Next Steps

After submission, we will conduct a 30 to 60 minute code review in person. We will ask you about your thinking and design choices.
