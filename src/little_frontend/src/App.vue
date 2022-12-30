<template>
  <div class="w-screen h-screen flex justify-center items-center">
    <div class="w-[40rem] h-96 rounded-md p-2 shadow-md shadow-gray-500">
      <div class="w-full h-[10%] flex items-center">
        <h1>Litt-le URL Shortener</h1>
      </div>
      <div class="w-full h-[90%] flex flex-col justify-center items-center">
        <div class="flex flex-col w-full space-y-1">
          <h1>Enter Original URL</h1>
          <input type="text" placeholder="e.g https://www.google.com?..." class="inputbox-styles" />
          <div class="w-full flex justify-center">
            <button class="btn-style">Shorten URL</button>
          </div>
        </div>
        <div class="flex w-full flex-col">
          <h1>Shortened URL</h1>
          <input type="text" placeholder="auto-generated" class="inputbox-styles border-gray-500" disabled="true" />
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="js">
import { ref } from 'vue'

export default {
  name: "App",
  setup: function() {
    // reactive data
    const shortenUrlRequest = ref({
      originalUrl: ''
    });

    // methods
    function shortenUrl() {

    }

    return {
      shortenUrlRequest, shortenUrl
    }
  }
}
</script>