Feature:uploading attachment

@attachment1
 Scenario: Complete a Quote with multiple attachments
  Given I am login a Sales Ops Rep
  And I select a quote with status as requested
  When I fill log quote complete popup with attachment
  Then I should verify attached fields
  
  @attachment2
 Scenario: Adding a Note with attachment on the quote details
  Given I am login a inside sales rep 
  And   I select a quote
  When  I add note with attachment
  Then  I should verify note with attachment 
 
 @attachment3
 Scenario: Adding a Note with attachment on the booking details
  Given I am login a inside sales rep 
  And   I select a booking
  When  I add note with attachment
  Then  I should verify note with attachment 
  
  @attachment4-nexmech
 Scenario: Request a booking with multiple attachments
  Given I am login a inside sales rep 
  And   I select a quote with status as delivered
  When  I fill request booking popup with multiple attachments
  Then  I should see the 2 attachments under purchase order field
 
 @attachment5  
 Scenario: verify user can change, delete and edit file name of attachment on Quote
  Given I am login a sales ops AM
  And I select a quote with status as requested
  When I attach attachment under quote and reseller quote
  Then I should see attached files
  When I delete attachment under quote and reseller quote
  Then I should not see attached files
 
 @attachment6-1
 Scenario: Verify user can add multiple attachments while completing a Booking from opportunity
  Given I am login as a Data Analyst
  And I select opportunity status as "Quote Requested"
  And I select complete booking option
  When I fill complete booking popup with quote and reseller attachment
  Then I should see attachment on opportunity details quotes subtab 
  
   @attachment6-2
 Scenario: Verify user can add multiple attachments while completing a Booking from opportunity
  Given I am login as a Data Analyst
  And I select opportunity status as "Not Contacted"
  And I select complete booking option
  When I fill complete booking popup with quote and reseller attachment
  Then I should see attachment on opportunity details quotes subtab 
  
   @attachment6-3
 Scenario: Verify user can add multiple attachments while completing a Booking from opportunity
  Given I am login as a Data Analyst
  And I select opportunity status as "Contacted"
  And I select complete booking option
  When I fill complete booking popup with quote and reseller attachment
  Then I should see attachment on opportunity details quotes subtab 
  
   @attachment6-4
 Scenario: Verify user can add multiple attachments while completing a Booking from opportunity
  Given I am login as a Data Analyst
  And I select opportunity status as "Quote Delivered"
  And I select complete booking option
  When I fill complete booking popup with quote and reseller attachment
  Then I should see attachment on opportunity details quotes subtab 
  
  @attachment7-1
 Scenario: Add an attachment with a note to the Activity Stream
  Given I am login as a Data Analyst
  And I select a "opportunity"
  When I post a note with attachment on activity stream on "opportunity" details page
  Then  I should verify note with attachment

  @attachment7-2
 Scenario: Add an attachment with a note to the Activity Stream
  Given I am login as a Data Analyst
  And I select a "booking"
  When I post a note with attachment on activity stream on "booking" details page
  Then  I should verify note with attachment

  @attachment7-3
 Scenario: Add an attachment with a note to the Activity Stream
  Given I am login as a Data Analyst
  And I select a "quote"
  When I post a note with attachment on activity stream on "quote" details page
  Then  I should verify note with attachment
  
  @attachment7-4
 Scenario: Add an attachment with a note to the Activity Stream
  Given I am login as a Data Analyst
  And I select a "contact"
  When I post a note with attachment on activity stream on "contact" details page
  Then  I should verify note with attachment
  
  @attachment7-5
 Scenario: Add an attachment with a note to the Activity Stream
  Given I am login as a Data Analyst
  And I select a "asset"
  When I post a note with attachment on activity stream on "asset" details page
  Then  I should verify note with attachment
  
  @attachment7-6
 Scenario: Add an attachment with a note to the Activity Stream
  Given I am login as a Data Analyst
  And I select a "task"
  When I post a note with attachment on activity stream on "task" details page
  Then  I should verify note with attachment  
  
   @attachment8-1
  Scenario: Delete a note with an attachment
   Given I am login as a Data Analyst
    And I select a "opportunity"
    When I post a note with attachment on activity stream on "opportunity" details page
    Then I should verify note with attachment on activity stream
    When I delete note with attachment on activity stream
    Then I should not see attached note and file
    
  @attachment8-2
  Scenario: Delete a note with an attachment
   Given I am login as a Data Analyst
    And I select a "booking"
    When I post a note with attachment on activity stream on "booking" details page
    Then I should verify note with attachment on activity stream
    When I delete note with attachment on activity stream
    Then I should not see attached note and file   
    
   @attachment8-3
  Scenario: Delete a note with an attachment
   Given I am login as a Data Analyst
    And I select a "quote"
    When I post a note with attachment on activity stream on "quote" details page
    Then I should verify note with attachment on activity stream
    When I delete note with attachment on activity stream
    Then I should not see attached note and file 
    
  @attachment8-4
  Scenario: Delete a note with an attachment
   Given I am login as a Data Analyst
    And I select a "task"
    When I post a note with attachment on activity stream on "task" details page
    Then I should verify note with attachment on activity stream
    When I delete note with attachment on activity stream
    Then I should not see attached note and file 
    
  @attachment8-5
  Scenario: Delete a note with an attachment
   Given I am login as a Data Analyst
    And I select a "contact"
    When I post a note with attachment on activity stream on "contact" details page
    Then I should verify note with attachment on activity stream
    When I delete note with attachment on activity stream
    Then I should not see attached note and file
    
  @attachment8-6
  Scenario: Delete a note with an attachment
   Given I am login as a Data Analyst
    And I select a "asset"
    When I post a note with attachment on activity stream on "asset" details page
    Then I should verify note with attachment on activity stream
    When I delete note with attachment on activity stream
    Then I should not see attached note and file  
    
    @attachment9-1
  Scenario: Add multiple attachments in a single post
   Given I am login as a Data Analyst
    And I select a "opportunity"
    When I post multiple attachments on activity stream on "opportunity" details page
    Then I should all see attached files are included in the new activity record
    
  @attachment9-2
  Scenario: Add multiple attachments in a single post
   Given I am login as a Data Analyst
    And I select a "booking"
    When I post multiple attachments on activity stream on "booking" details page
    Then I should all see attached files are included in the new activity record
    
  @attachment9-3
  Scenario: Add multiple attachments in a single post
   Given I am login as a Data Analyst
    And I select a "quote"
    When I post multiple attachments on activity stream on "quote" details page
    Then I should all see attached files are included in the new activity record
  
     
  @attachment9-4
  Scenario: Add multiple attachments in a single post
   Given I am login as a Data Analyst
    And I select a "task"
    When I post multiple attachments on activity stream on "task" details page
    Then I should all see attached files are included in the new activity record
   
  @attachment9-5
  Scenario: Add multiple attachments in a single post
   Given I am login as a Data Analyst
    And I select a "contact"
    When I post multiple attachments on activity stream on "contact" details page
    Then I should all see attached files are included in the new activity record
    
  @attachment9-6
  Scenario: Add multiple attachments in a single post
    Given I am login as a Data Analyst
    And I select a "asset"
    When I post multiple attachments on activity stream on "asset" details page
    Then I should all see attached files are included in the new activity record
  
    @attachment10-1    
   Scenario: Delete an attachment from an activity record with multiple attachments
    Given I am login as a Data Analyst
    And I select a "opportunity"
    When I post multiple attachments on activity stream on "opportunity" details page
    Then I should all see attached files are included in the new activity record
    When I delete one attachment of recently posted activity
	Then I should see all uploaded files except deleted one  
	
  @attachment10-2
   Scenario: Delete an attachment from an activity record with multiple attachments
    Given I am login as a Data Analyst
    And I select a "booking"
    When I post multiple attachments on activity stream on "booking" details page
    Then I should all see attached files are included in the new activity record
    When I delete one attachment of recently posted activity
	Then I should see all uploaded files except deleted one  
	
  @attachment10-3  
   Scenario: Delete an attachment from an activity record with multiple attachments
    Given I am login as a Data Analyst
    And I select a "quote"
    When I post multiple attachments on activity stream on "quote" details page
    Then I should all see attached files are included in the new activity record
    When I delete one attachment of recently posted activity
	Then I should see all uploaded files except deleted one  
	
  @attachment10-4    
   Scenario: Delete an attachment from an activity record with multiple attachments
    Given I am login as a Data Analyst
    And I select a "contact"
    When I post multiple attachments on activity stream on "contact" details page
    Then I should all see attached files are included in the new activity record
    When I delete one attachment of recently posted activity
	Then I should see all uploaded files except deleted one  
	
  @attachment10-5   
   Scenario: Delete an attachment from an activity record with multiple attachments
    Given I am login as a Data Analyst
    And I select a "task"
    When I post multiple attachments on activity stream on "task" details page
    Then I should all see attached files are included in the new activity record
    When I delete one attachment of recently posted activity
	Then I should see all uploaded files except deleted one  

  @attachment10-6  
   Scenario: Delete an attachment from an activity record with multiple attachments
    Given I am login as a Data Analyst
    And I select a "asset"
    When I post multiple attachments on activity stream on "asset" details page
    Then I should all see attached files are included in the new activity record
    When I delete one attachment of recently posted activity
	Then I should see all uploaded files except deleted one  
	
	  @attachment11-1
   Scenario: Verify Activities on Task
    Given I am login as a Data Analyst
    When I create a task with attachment
    Then I should verify activity with note and attachment
    When I delete one attachment of recently posted activity
    Then I verify attachment deleted from activity
	
  @attachment11-2
   Scenario: Verify Activities on Task
    Given I am login as a Data Analyst
    And I selected a task with status:"Open"
    When I fill task placed on hold popup with attachment
    Then I verify activity with message "Bill Moor placed a task on hold"
    
  @attachment11-3
   Scenario: Verify Activities on Task
    Given I am login as a Data Analyst
    And I selected a task with status:"Open"
    When I fill close task - unsuccessfully popup with attachment
    Then I verify activity with message "Bill Moor closed a task unsuccessfully"
    
    @attachment11-4
   Scenario: Verify Activities on Task
    Given I am login as a Data Analyst
    And I selected a task with status:"Open"
    When I select log quote complete
    Then I verify activity with message "Bill Moor completed a task"  
 
    @attachment11-5
   Scenario: Verify Activities on Task
    Given I am login as a Data Analyst
    And I selected a task with status:"On Hold"
    When I select Release Hold
    Then I verify activity with message "Bill Moor released a task"    
    
    @attachment11-6
   Scenario: Verify Activities on Task
    Given I am login as a Data Analyst
    And I selected a task with status:"Closed - Unsuccessfully"
    When I select Re-open Task
    Then I verify activity with message "Bill Moor reopened a task"  