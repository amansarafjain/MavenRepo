Feature:Business scenarios uploading attachment

 @bs1
Scenario: Activity: Add/Delete note and attachment in Opportunity
 Given I am login a inside sales rep
 And  I select opportunity status as "Not Contacted"
 When I post a note with attachment on activity stream on "opportunity" details page  
 Then I should verify note with attachment on activity stream
 When I delete attachment
 Then I should verify attachment deleted
 When I deleted note
 Then I should verify note deleted
  
  @bs2
  Scenario: Activity: Add/Delete note and attachment in Quotes
   Given I am login a inside sales rep
   And I select a "quote"
   When I post a note with attachment on activity stream on "quote" details page  
   Then I should verify note with attachment on activity stream
   When I delete attachment
   Then I should verify attachment deleted
   When I deleted note
   Then I should verify note deleted
   
     @bs3
  Scenario: Activity: Add/Delete note and attachment in Quotes
   Given I am login a inside sales rep
    And I select a booking
   When I post a note with attachment on activity stream on "booking" details page  
   Then I should verify note with attachment on activity stream
   When I delete attachment
   Then I should verify attachment deleted
   When I deleted note
   Then I should verify note deleted
  
