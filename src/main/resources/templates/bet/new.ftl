<#import "../common/page.ftl" as common>
<@common.page>
    <div class="row" style="margin-top: 60px">
        <div class="col"></div>
        <div class="col">
            <form action="/bet/new" method="post">
                <div class="mb-3">
                    <label for="bet" class="form-label">Chose option:</label>
                    <select name="bet" class="form-select" aria-describedby="betHelp">
                        <option value="RED">Red</option>
                        <option value="BLACK">Black</option>
                        <option value="ZERO">Zero</option>
                    </select>
                    <div id="betHelp" class="form-text">Chose on what to bet.</div>
                </div>


                <div class="mb-3">
                    <label for="betValue" class="form-label">Bet Value:</label>
                    <input type="number" class="form-control" name="betValue" aria-describedby="betValueHelp">
                    <div id="betValueHelp" class="form-text">Choose how much to bet.</div>
                </div>

                <button type="submit" class="btn btn-dark" style="margin-top: 10px">Bet</button>
            </form>
        </div>
        <div class="col"></div>
    </div>
</@common.page>