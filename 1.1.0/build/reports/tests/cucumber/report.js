$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Business_Scenarios.feature");
formatter.feature({
  "line": 1,
  "name": "Business scenarios uploading attachment",
  "description": "",
  "id": "business-scenarios-uploading-attachment",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Activity: Add/Delete note and attachment in Opportunity",
  "description": "",
  "id": "business-scenarios-uploading-attachment;activity:-add/delete-note-and-attachment-in-opportunity",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@bs1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am login a inside sales rep",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I select opportunity status as \"Not Contacted\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I post a note with attachment on activity stream on \"opportunity\" details page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should verify note with attachment on activity stream",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I delete attachment",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should verify attachment deleted",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I deleted note",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I should verify note deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepFile.i_am_login_a_inside_sales_rep()"
});
formatter.result({
  "duration": 22559609466,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not Contacted",
      "offset": 32
    }
  ],
  "location": "upload_attachmentStepdefs.i_select_opportunity_status_as(String)"
});
formatter.result({
  "duration": 33866818931,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "opportunity",
      "offset": 53
    }
  ],
  "location": "upload_attachmentStepdefs.i_post_a_note_with_attachment_on_activity_stream_on_details_page(String)"
});
formatter.result({
  "duration": 21424209168,
  "status": "passed"
});
formatter.match({
  "location": "upload_attachmentStepdefs.i_should_verify_note_with_attachment_onactivity_stream()"
});
formatter.result({
  "duration": 53003726,
  "status": "passed"
});
formatter.match({
  "location": "upload_attachmentStepdefs.i_delete_attachment()"
});
formatter.result({
  "duration": 2090087046,
  "status": "passed"
});
formatter.match({
  "location": "upload_attachmentStepdefs.i_should_verify_attachment_deleted()"
});
formatter.result({
  "duration": 2035378247,
  "status": "passed"
});
formatter.match({
  "location": "upload_attachmentStepdefs.i_deleted_note()"
});
formatter.result({
  "duration": 5080167723,
  "status": "passed"
});
formatter.match({
  "location": "upload_attachmentStepdefs.i_should_verify_note_deleted()"
});
formatter.result({
  "duration": 48352599,
  "status": "passed"
});
});