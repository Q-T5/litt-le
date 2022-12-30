<template>
  <div class="w-screen h-screen flex justify-center items-center">
    <div class="w-[40rem] h-80 rounded-md p-2 shadow-md shadow-gray-500">
      <div class="w-full h-[10%] flex items-center">
        <h1 class="font-ubuntu text-2xl">Litt-le URL Shortener</h1>
      </div>
      <div class="w-full flex justify-center">
        <img src="/src/assets/logo.svg" alt="litt-le-logo" class="w-12" />
      </div>
      <div class="w-full flex flex-col justify-center items-center">
        <div class="flex flex-col w-full space-y-1">
          <h1 class="font-nunito font-semibold">Paste/ Enter Original URL</h1>
          <input type="text" placeholder="e.g https://www.google.com?..." class="inputbox-styles"
          v-model="shortenUrlRequest.originalUrl" />
          <div class="w-full flex justify-center">
            <button class="btn-style" @click="shortenUrl" :disabled="buttonDisabled">Shorten URL</button>
          </div>
        </div>
        <div class="flex w-full flex-col">
          <h1 class="font-nunito font-semibold">Shortened URL</h1>
          <input type="text" placeholder="auto-generated" class="inputbox-styles border-gray-500" disabled="true"
          v-model="responseString" />
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="js">
import { ref, watch } from 'vue'

export default {
  name: "App",
  setup: function() {
    // reactive data
    const shortenUrlRequest = ref({
      originalUrl: ''
    });
    const responseString = ref("");
    const buttonDisabled = ref(true)

    // methods
    function shortenUrl() {
      fetch("/r/shorten", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(shortenUrlRequest.value)
      }).then((response) => {
        if(response.status !== 200) {
          responseString.value = "Unknown Error! Please Try Again";
        }

        return response.text();
      }).then((data) => {
        responseString.value = data;
      })
    }

    // watchers
    watch(() => shortenUrlRequest.value.originalUrl, (newValue) => {
      if(newValue !== "" && (newValue.startsWith("http://") || newValue.startsWith("https://"))) {
        buttonDisabled.value = false
      } else {
        buttonDisabled.value = true
      }
    });

    return {
      shortenUrlRequest, shortenUrl, responseString, buttonDisabled
    }
  }
}
</script>