#!/bin/bash
# Fix Android Studio Java 25 Issue

echo "🔧 Fixing Android Studio Java 25 compatibility..."

# Detect OS
if [[ "$OSTYPE" == "darwin"* ]]; then
  # macOS
  echo "Detected macOS - clearing caches..."
  rm -rf ~/Library/Caches/JetBrains/AndroidStudio*
  rm -rf ~/Library/Application\ Support/JetBrains/AndroidStudio*
  echo "✅ macOS caches cleared"
  
elif [[ "$OSTYPE" == "linux-gnu"* ]]; then
  # Linux
  echo "Detected Linux - clearing caches..."
  rm -rf ~/.cache/JetBrains/AndroidStudio*
  rm -rf ~/.config/JetBrains/AndroidStudio*
  echo "✅ Linux caches cleared"
fi

echo "🎯 Pulling latest config from GitHub..."
git pull

echo "✅ Done! Now restart Android Studio"
