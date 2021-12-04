describe("Register test case: ", function() {
  it("Register: ", function() {
    cy.visit("http://localhost:8080/register");
    cy.get(".name").type("Samuel Quirama");
    cy.get(".user").type("KIRA2555");
    cy.get(".email").type("kira@gmail.com");
    cy.get(".password").type("123");
  });
  it("Register failed: ", function() {
    cy.visit("http://localhost:8080/register");
    cy.get(".name").type("Quirama Samuel");
    cy.get(".user").type("KIRA2555");
    cy.get(".email").type("kira@gmail.com");
    cy.get(".password").type("123");
  });
});