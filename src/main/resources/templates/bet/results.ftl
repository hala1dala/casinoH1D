<#import "../common/page.ftl" as common>
<@common.page>
    <h2>All bets:</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Number of game</th>
            <th scope="col">Result</th>
            <th scope="col">Date</th>
        </tr>
        </thead>
        <#list results as result>
            <tr>
                <td>${result.id}</td>
                <td>${result.result}</td>
                <td>${result.dateTime}</td>
            </tr>
        </#list>
    </table>
</@common.page>l