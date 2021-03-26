<#import "../common/page.ftl" as common>
<@common.page>
    <h2>All bets:</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Birthday</th>
            <th scope="col">Username</th>
            <th scope="col">Balance</th>
        </tr>
        </thead>
        <#list profiles as profile>
            <tr>
                <td>${profile.firstName}</td>
                <td>${profile.lastName}</td>
                <td>${profile.birthday}</td>
                <td>${profile.username}</td>
                <td>${profile.balance}</td>
            </tr>
        </#list>
    </table>
</@common.page>l