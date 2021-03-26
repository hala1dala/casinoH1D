<#import "../common/page.ftl" as common>
<@common.page>
    <h2>All bets:</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Bet</th>
            <th scope="col">Amount</th>
            <th scope="col">Is Active</th>
        </tr>
        </thead>
        <#list bets as bet>
            <tr>
                <td>${bet.bet}</td>
                <td>${bet.betValue}</td>
                <td>${bet.active?c}</td>
            </tr>
        </#list>
    </table>
</@common.page>l